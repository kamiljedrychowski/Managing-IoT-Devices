package com.iot.device.kafka.entity;

import lombok.Builder;
import lombok.Data;

@Data
public class DeviceEvent {

    private String deviceUuid;
    private String deviceEvent;
    private Double additionalData;

}
