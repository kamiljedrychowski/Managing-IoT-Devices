package com.iot.device_status.kafka;

import com.iot.device_status.kafka_entity.DeviceStatusKafka;
import com.iot.device_status.entity.DeviceStatus;
import com.iot.device_status.entity.StatusData;
import com.iot.device_status.repository.DeviceStatusRepository;
import com.iot.device_status.stream.BaseDeviceEventSinkStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class DeviceStatusSinkService {

    private final DeviceStatusRepository deviceStatusRepository;

    @Autowired
    public DeviceStatusSinkService(DeviceStatusRepository deviceStatusRepository) {
        this.deviceStatusRepository = deviceStatusRepository;
    }

//    @StreamListener(BaseDeviceEventSinkStream.BASE_DEVICE_EVENTS_STREAM)
//    public void handleGreetings(@Payload DeviceStatusKafka deviceStatusKafka) {
//        log.debug("Received message: {}", deviceStatusKafka);
//        if(!checkData(deviceStatusKafka)) {
//            return;
//        }
//        processData(deviceStatusKafka);
//    }

    private boolean checkData(DeviceStatusKafka deviceStatusKafka) {
        return deviceStatusKafka.getDeviceUuid() != null && deviceStatusKafka.getStatusType() != null;
    }

    private void processData(DeviceStatusKafka deviceStatusKafka) {
        DeviceStatus deviceStatusData = createDeviceStatusData(deviceStatusKafka);
        deviceStatusRepository.save(deviceStatusData);
        log.debug("Saving device status data into database: {}", deviceStatusData);
    }

    private DeviceStatus createDeviceStatusData(DeviceStatusKafka deviceStatusKafka) {
        return DeviceStatus.builder()
                .statusUuid(UUID.randomUUID().toString())
                .timestamp(deviceStatusKafka.getTimestamp())
                .statusData(StatusData.builder()
                        .deviceUuid(deviceStatusKafka.getDeviceUuid())
                        .statusType(deviceStatusKafka.getStatusType())
                        .statusData(deviceStatusKafka.getStatusData())
                        .additionalData(deviceStatusKafka.getAdditionalData())
                        .build())
                .build();
    }

}
