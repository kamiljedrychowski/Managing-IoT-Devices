package com.iot.device_event.repository;

import com.iot.device_event.entity.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeviceRepository extends CrudRepository<Device, Long> {
    Device getDeviceByDeviceUuid(String deviceUuid);

}
