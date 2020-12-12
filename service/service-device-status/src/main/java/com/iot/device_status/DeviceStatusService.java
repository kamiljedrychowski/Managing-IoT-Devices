package com.iot.device_status;

import com.iot.device_status.repository.DeviceStatusRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class DeviceStatusService {

    private final DeviceStatusRepository deviceStatusRepository;

    @Autowired
    public DeviceStatusService(DeviceStatusRepository deviceStatusRepository) {
        this.deviceStatusRepository = deviceStatusRepository;
    }

}
