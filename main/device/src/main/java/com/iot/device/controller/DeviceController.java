package com.iot.device.controller;

import com.iot.device.DeviceService;
import com.iot.device.dto.DeviceDto;
import com.iot.device.kafka.entity.DeviceEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping("/device/add")
    public void addDevice(@RequestBody DeviceDto deviceDto) {
        deviceService.addNewDevice(deviceDto);
    }

    @DeleteMapping("/device/delete/{deviceUuid}")
    public void deleteDevice(@PathVariable String deviceUuid) {
        deviceService.deleteDevice(deviceUuid);
    }

    @GetMapping("/device/get/{deviceUuid}")
    public ResponseEntity<String> getDevice(@PathVariable String deviceUuid) {
        return deviceService.getDevice(deviceUuid);
    }

    @GetMapping("/device/get")
    public ResponseEntity<String> getDevices() {
        return deviceService.getDevices();
    }

    @PostMapping("device/event")
    public ResponseEntity createDeviceEvent(@RequestBody DeviceEvent deviceEvent) {
        return deviceService.createDeviceEvent(deviceEvent);
    }
}
