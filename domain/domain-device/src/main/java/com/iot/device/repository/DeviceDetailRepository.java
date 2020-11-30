package com.iot.device.repository;

import com.iot.device.entity.DeviceDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceDetailRepository extends CrudRepository<DeviceDetail, Long> {

}
