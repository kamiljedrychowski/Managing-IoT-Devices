package com.iot.device.dto;

import lombok.Data;

@Data
public class DeviceDto {

    //Device
    private String deviceName;
    private String deviceType;

    //Device details
    private String deviceCountry;
    private String deviceCity;
    private String deviceAddress;
    private String deviceBrand;
    private String deviceModel;
}