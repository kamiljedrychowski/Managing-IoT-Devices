package com.iot.device_status.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "DEVICE_COMMAND")
public class DeviceCommand {

    private String deviceUuid;
    private String deviceEvent;
    private Double additionalData;
    private LocalDateTime commandTime;
}
