package com.iot.device_mockup.kafka;

import com.iot.device_mockup.kafka.entity.DeviceEvent;
import com.iot.device_mockup.kafka.stream.MockDeviceStream;
import com.iot.device_status.enums.StatusType;
import com.iot.device_status.kafka_entity.DeviceStatusKafka;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@Slf4j
@EnableBinding(MockDeviceStream.class)
public class DeviceEventListener {

    private final DeviceStatusProducer deviceStatusProducer;

    public DeviceEventListener(DeviceStatusProducer deviceStatusProducer) {
        this.deviceStatusProducer = deviceStatusProducer;
    }

    @StreamListener(MockDeviceStream.BASE_DEVICE_EVENTS_STREAM_INPUT)
    public void handleDeviceCommand(@Payload DeviceEvent deviceEvent) {
        log.debug("Received message: {}", deviceEvent);
        //TODO dodać CACHE do sprawdzania czy status nie jest ustwiany ponownie na taki sam

        if (!checkData(deviceEvent)) {
            log.error("Received message is incorrect: {}", deviceEvent);
            return;
        }

        processData(deviceEvent);
    }

    private boolean checkData(DeviceEvent deviceEvent) {
        return deviceEvent.getDeviceUuid() != null && deviceEvent.getDeviceEvent() != null;
    }

    private void processData(DeviceEvent deviceEvent) {
        DeviceStatusKafka deviceCommand = createDeviceCommand(deviceEvent);
        deviceStatusProducer.send(deviceCommand);
    }

    private DeviceStatusKafka createDeviceCommand(DeviceEvent deviceEvent) {
        String statusType = null;
        switch (deviceEvent.getDeviceEvent()) {
            case "TURN_ON_DEVICE" :
                statusType = StatusType.DEVICE_TURN_ON.toString();
                break;
            case "TURN_OFF_DEVICE" :
                statusType = StatusType.DEVICE_TURN_OFF.toString();
                break;
            case "CHANGE_TEMPERATURE" :
                statusType = StatusType.DEVICE_TEPERATURE_RAPORT.toString();
        }
        return DeviceStatusKafka.builder()
                .deviceUuid(deviceEvent.getDeviceUuid())
                .statusType(statusType)
                .statusData(deviceEvent.getAdditionalData())
                .timestamp(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC))
                .build();
    }

}
