package com.iot.device_status.repository;

import com.iot.device_status.entity.DeviceCommand;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeviceCommandRepository  extends MongoRepository<DeviceCommand, Long> {
}
