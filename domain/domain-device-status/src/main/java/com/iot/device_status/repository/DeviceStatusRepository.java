package com.iot.device_status.repository;

import com.iot.device_status.entity.DeviceStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceStatusRepository extends MongoRepository<DeviceStatus, Long> {
}
