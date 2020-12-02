package com.iot.device_mockup.kafka.entity;

import lombok.Data;

@Data
public class DeviceEvent {

    private String deviceUuid;
    private String deviceEvent;
    private Double additionalData;

}
