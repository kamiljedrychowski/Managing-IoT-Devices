package com.iot.device_status.controller;

import com.iot.device_status.DeviceStatusService;
import com.iot.device_status.entity.DeviceStatus;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExampleController {

    private final DeviceStatusService deviceStatusService;

    public ExampleController(DeviceStatusService deviceStatusService) {
        this.deviceStatusService = deviceStatusService;
    }

    @PostMapping("/send/")
    public void sendExample() {
        deviceStatusService.addNewExample();
    }

    @GetMapping("/get")
    public List<DeviceStatus> getExample() {
        return deviceStatusService.getAllExample();
    }

}