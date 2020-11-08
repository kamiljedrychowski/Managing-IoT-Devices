package com.iot.device_status.config;

import com.iot.device_status.stream.DeviceStatusSinkStream;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(DeviceStatusSinkStream.class)
public class KafkaConfig {
}
