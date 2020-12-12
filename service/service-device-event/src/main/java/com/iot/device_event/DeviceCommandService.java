package com.iot.device_event;


import com.iot.device_event.entity.Device;
import com.iot.device_event.enums.StatusType;
import com.iot.device_event.entity.DeviceEvent;
import com.iot.device_event.enums.DeviceEvents;
import com.iot.device_event.repository.DeviceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DeviceCommandService {

    @Autowired
    private DeviceRepository deviceRepository;

    public Device getDeviceByUuid(String deviceUuid) {
        return deviceRepository.getDeviceByDeviceUuid(deviceUuid);
    }

    public void changeTemperature(DeviceEvent deviceEvent) {
        Device device = getDeviceByUuid(deviceEvent.getDeviceUuid());
        device.setDeviceStatusInformation(deviceEvent.getAdditionalData());
        deviceRepository.save(device);
    }

    public void turnOnOff(DeviceEvent deviceEvent) {
        Device device = getDeviceByUuid(deviceEvent.getDeviceUuid());
        device.setDeviceStatus(mapDeviceEventToStatus(deviceEvent.getDeviceEvent()));
        deviceRepository.save(device);
    }

    private StatusType mapDeviceEventToStatus(String deviceEvent) {
        if (deviceEvent.equals(DeviceEvents.TURN_OFF_DEVICE.toString())) {
            return StatusType.OFF;
        } else if (deviceEvent.equals(DeviceEvents.TURN_ON_DEVICE.toString())) {
            return StatusType.ON;
        }
        return null;
    }




}
