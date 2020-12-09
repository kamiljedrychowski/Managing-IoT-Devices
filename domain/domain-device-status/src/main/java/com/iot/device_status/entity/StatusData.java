package com.iot.device_status.entity;

import com.iot.device_status.enums.StatusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatusData {
    private String deviceUuid;
    private StatusType statusType;
    private Double statusData;
    private Double additionalData;
}
