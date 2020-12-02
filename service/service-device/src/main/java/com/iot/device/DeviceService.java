package com.iot.device;

import com.iot.device.dto.DeviceDto;
import com.iot.device.entity.Device;
import com.iot.device.entity.DeviceDetail;
import com.iot.device.enums.DeviceType;
import com.iot.device.enums.StatusType;
import com.iot.device.repository.DeviceRepository;
import com.iot.user.entity.UserData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                .deviceStatus(StatusType.DEVICE_TURN_OFF)
                .deviceMainOwner(-1L)
                .deviceName(deviceDto.getDeviceName())
                .deviceDetail(deviceDetail)
                .deviceCreationTime(LocalDateTime.now())
                .build();

        deviceRepository.save(device);
        log.info("Device added to database");
    }

    @Transactional
    public void deleteDevice(String deviceUuid) {
        Device device = deviceRepository.getDeviceByDeviceUuid(deviceUuid);
        if (device == null) {
            log.error("Wrong deviceUuid: {}", deviceUuid);
            return;
        }
        Long detailId = device.getDeviceDetail().getDetailId();
        deviceRepository.delete(device);
        deviceDetailService.deleteDeviceDetailById(detailId);
        log.info("Device deleted from database");
    }

    public ResponseEntity<String> getDevice(String deviceUuid) {
        Device device = deviceRepository.getDeviceByDeviceUuid(deviceUuid);
        if (device == null) {
            log.error("Wrong deviceUuid: {}", deviceUuid);
            return new ResponseEntity<>("", HttpStatus.FORBIDDEN);
        }

       return new ResponseEntity<>(device.toString(), HttpStatus.OK);
    }

    public ResponseEntity<String> getDevices() {
        return new ResponseEntity<>(deviceRepository.findAll().toString(), HttpStatus.OK);
    }
}
