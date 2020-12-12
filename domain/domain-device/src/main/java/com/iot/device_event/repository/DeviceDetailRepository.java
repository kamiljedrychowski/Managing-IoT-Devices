package com.iot.device_event.repository;

import com.iot.device_event.entity.DeviceDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceDetailRepository extends CrudRepository<DeviceDetail, Long> {

}
