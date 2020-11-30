package com.iot.device.controller;

import com.iot.device.DeviceService;
import com.iot.device.dto.DeviceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        log.info("Device added to database");
    }
}
