package com.iot.device_status.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "DEVICE_STATUS")
public class DeviceStatus {
    private String statusUuid;
    private Long timestamp;
    private StatusData statusData;
}
