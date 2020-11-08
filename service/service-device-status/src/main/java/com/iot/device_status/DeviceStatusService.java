package com.iot.device_status;

import com.iot.device_status.entity.DeviceStatus;
import com.iot.device_status.entity.StatusData;
import com.iot.device_status.enums.StatusType;
import com.iot.device_status.repository.DeviceStatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@Slf4j
public class DeviceStatusService {

    public DeviceStatusService(DeviceStatusRepository deviceStatusRepository) {
        this.deviceStatusRepository = deviceStatusRepository;
    }

    private final DeviceStatusRepository deviceStatusRepository;

    public void addNewExample() {
        StatusData statusData = StatusData.builder()
                .statusData(0.2)
                .additionalData("additional data")
                .statusType(StatusType.DEVICE_BATTERY_STATUS)
                .deviceUuid(UUID.randomUUID().toString())
                .build();

        DeviceStatus deviceStatus = DeviceStatus.builder()
                .statusUuid(UUID.randomUUID().toString())
                .timestamp(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC))
                .statusData(statusData)
                .build();

        deviceStatusRepository.save(deviceStatus);
    }

    public List<DeviceStatus> getAllExample() {
        return deviceStatusRepository.findAll();
    }


}
