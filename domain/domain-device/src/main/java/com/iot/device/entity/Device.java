package com.iot.device.entity;

import com.iot.device.enums.DeviceType;
import com.iot.device.enums.StatusType;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table(name = "DEVICE")
@Entity
@Builder
public class Device {

    @Id
    @GeneratedValue
    @Column(name = "device_id")
    Long deviceId;

    @Column(name = "device_uuid")
    String deviceUuid;

    @Column(name = "device_type")
    @Enumerated(EnumType.STRING)
    DeviceType deviceType;

    @Column(name = "device_name")
    String deviceName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_detail")
    DeviceDetail deviceDetail;

    @Column(name = "device_status")
    @Enumerated(EnumType.STRING)
    StatusType deviceStatus;

    @Column(name = "device_battery")
    Double deviceBattery;

    @Column(name = "device_status_information")
    Double deviceStatusInformation;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "device_main_owner")
    @Column(name = "device_main_owner")
    Long deviceMainOwner;
//    User deviceMainOwner;

    @Column(name = "device_creation_time")
    LocalDateTime deviceCreationTime;


}
