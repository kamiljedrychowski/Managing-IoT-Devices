package com.iot.device.config;

import com.iot.device.kafka.stream.BaseDeviceEventsStream;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(BaseDeviceEventsStream.class)
public class KafkaConfig {
}