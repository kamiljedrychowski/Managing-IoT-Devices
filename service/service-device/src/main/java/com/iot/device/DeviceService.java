package com.iot.device;

import com.iot.device.dto.DeviceDto;
import com.iot.device.entity.Device;
import com.iot.device.entity.DeviceDetail;
import com.iot.device.enums.DeviceType;
import com.iot.device.enums.StatusType;
import com.iot.device.repository.DeviceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceDetailService deviceDetailService;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository, DeviceDetailService deviceDetailService) {
        this.deviceRepository = deviceRepository;
        this.deviceDetailService = deviceDetailService;
    }

    public void addNewDevice(DeviceDto deviceDto) {

        DeviceDetail deviceDetail = deviceDetailService.addNewDeviceDetail(deviceDto);

        Device device = Device.builder()
                .deviceUuid(UUID.randomUUID().toString())
                .deviceType(DeviceType.valueOf(deviceDto.getDeviceType()))
                .deviceStatus(StatusType.DEVICE_TURN_ON)
                .deviceMainOwner(0L)
//                .deviceMainOwner(User.builder().build())
                .deviceName(deviceDto.getDeviceName())
                .deviceDetail(deviceDetail)
                .deviceCreationTime(LocalDateTime.now())
                .build();

        log.info(device.toString());
        deviceRepository.save(device);
    }

}
