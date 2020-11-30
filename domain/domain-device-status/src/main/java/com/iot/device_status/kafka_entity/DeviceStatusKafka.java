package com.iot.device_status.kafka_entity;

import com.iot.device_status.enums.StatusType;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class DeviceStatusKafka {
    private String deviceUuid;
    private StatusType statusType;
    private Long timestamp;
    private Double statusData;
    private String additionalData;

}
