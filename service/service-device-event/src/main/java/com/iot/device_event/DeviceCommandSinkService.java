package com.iot.device_event;

import com.iot.device_event.entity.DeviceEvent;
import com.iot.device_event.enums.DeviceEvents;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@EnableBinding(DeviceEventsStream.class)
public class DeviceCommandSinkService {

    private final DeviceCommandService deviceCommandService;

    public DeviceCommandSinkService(DeviceCommandService deviceCommandService) {
        this.deviceCommandService = deviceCommandService;
    }

    @StreamListener(DeviceEventsStream.BASE_DEVICE_EVENTS_STREAM)
    public void handleDeviceCommand(@Payload DeviceEvent deviceEvent) {
        log.debug("Received message: {}", deviceEvent);
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
        changeDeviceStatus(deviceEvent);
        log.debug("Saving device changes into database: {}", deviceEvent);
    }

    private void changeDeviceStatus(DeviceEvent deviceEvent) {
        if (deviceEvent.getDeviceEvent().equals(DeviceEvents.TURN_OFF_DEVICE.toString())
        || deviceEvent.getDeviceEvent().equals(DeviceEvents.TURN_ON_DEVICE.toString())) {
            deviceCommandService.turnOnOff(deviceEvent);
        } else if (deviceEvent.getDeviceEvent().equals(DeviceEvents.CHANGE_TEMPERATURE.toString())) {
            deviceCommandService.changeTemperature(deviceEvent);
        }
    }
}
