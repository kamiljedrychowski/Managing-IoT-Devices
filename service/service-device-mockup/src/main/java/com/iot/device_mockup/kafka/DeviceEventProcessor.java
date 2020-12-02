package com.iot.device_mockup.kafka;

import com.iot.device_mockup.kafka.entity.DeviceEvent;
import com.iot.device_mockup.kafka.stream.BaseDeviceEventsStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DeviceEventProcessor {

    @StreamListener(BaseDeviceEventsStream.BASE_DEVICE_EVENTS_STREAM)
    public void handleDeviceCommand(@Payload DeviceEvent deviceEvent) {
        log.debug("Received message: {}", deviceEvent);
//        if (!checkData(deviceEvent)) {
            log.error("Received message is incorrect: {}", deviceEvent);
//            return;
//        }

//        processData(deviceEvent);
    }

//    private boolean checkData(DeviceEvent deviceEvent) {
//        return deviceEvent.getDeviceUuid() != null && deviceEvent.getDeviceEvent() != null;
//    }
//
//    private void processData(DeviceEvent deviceEvent) {
//        DeviceCommand deviceCommand = createDeviceCommand(deviceEvent);
//        deviceCommandRepository.save(deviceCommand);
//        log.debug("Saving device event data into database: {}", deviceCommand);
//    }
//
//    private DeviceCommand createDeviceCommand(DeviceEvent deviceEvent) {
//        return DeviceCommand.builder()
//                .deviceEvent(deviceEvent.getDeviceEvent())
//                .deviceUuid(deviceEvent.getDeviceUuid())
//                .additionalData(deviceEvent.getAdditionalData())
//                .commandTime(LocalDateTime.now())
//                .build();
//    }

}