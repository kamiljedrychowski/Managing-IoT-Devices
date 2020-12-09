package com.iot.device_status.kafka_entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class DeviceStatusKafka {

    private String deviceUuid;
    private String statusType;
    private Long timestamp;
    private Double statusData;
    private Double additionalData;

}
