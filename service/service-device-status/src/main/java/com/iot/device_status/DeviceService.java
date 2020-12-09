package com.iot.device_status;

import com.iot.device.entity.Device;
import com.iot.device.enums.StatusType;
import com.iot.device.kafka.entity.DeviceEvent;
import com.iot.device.kafka.enums.DeviceEvents;
import com.iot.device.repository.DeviceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DeviceService {
    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

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
