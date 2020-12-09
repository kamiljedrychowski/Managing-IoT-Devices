package com.iot.device_mockup.kafka.entity;

import lombok.Data;

@Data
public class DeviceStatus {

    private String deviceUuid;
    private String statusType;
    private Long timestamp;
    private Double statusData;
    private Double additionalData;
//    private String deviceUuid;
//    private String deviceStatus;
//    private Double additionalData;
//    private Double deviceBattery;

}
