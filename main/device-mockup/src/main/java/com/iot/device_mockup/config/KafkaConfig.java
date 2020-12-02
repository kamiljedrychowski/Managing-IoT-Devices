package com.iot.device_mockup.config;

import com.iot.device_mockup.kafka.stream.BaseDeviceEventsStream;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(BaseDeviceEventsStream.class)
public class KafkaConfig {
}
