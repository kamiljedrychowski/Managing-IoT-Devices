package com.iot.device_event;

import com.iot.device_event.dto.DeviceDto;
import com.iot.device_event.entity.DeviceDetail;
import com.iot.device_event.repository.DeviceDetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class DeviceDetailService {

    private final DeviceDetailRepository deviceDetailRepository;


    public DeviceDetailService(DeviceDetailRepository deviceDetailRepository) {
        this.deviceDetailRepository = deviceDetailRepository;
    }

    public DeviceDetail addNewDeviceDetail(DeviceDto deviceDto) {
        DeviceDetail deviceDetail = DeviceDetail.builder()
                .deviceModel(deviceDto.getDeviceModel())
                .deviceCountry(deviceDto.getDeviceCountry())
                .deviceCity(deviceDto.getDeviceCity())
                .deviceBrand(deviceDto.getDeviceBrand())
                .deviceAddress(deviceDto.getDeviceAddress())
                .deviceDetailCreationTime(LocalDateTime.now())
                .build();

        deviceDetailRepository.save(deviceDetail);
        return deviceDetail;
    }

    public void deleteDeviceDetailById(Long id) {
        deviceDetailRepository.deleteById(id);
    }

}
