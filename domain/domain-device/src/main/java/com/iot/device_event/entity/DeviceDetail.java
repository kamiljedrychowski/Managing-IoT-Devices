package com.iot.device_event.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table(name = "DEVICE_DETAIL")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceDetail {

    @Id
    @GeneratedValue
    @Column(name = "detail_id")
    Long detailId;

    @Column(name = "device_country")
    String deviceCountry;

    @Column(name = "device_city")
    String deviceCity;

    @Column(name = "device_address")
    String deviceAddress;

    @Column(name = "device_brand")
    String deviceBrand;

    @Column(name = "device_model")
    String deviceModel;

    @Column(name = "device_detail_creation_time")
    LocalDateTime deviceDetailCreationTime;
}
