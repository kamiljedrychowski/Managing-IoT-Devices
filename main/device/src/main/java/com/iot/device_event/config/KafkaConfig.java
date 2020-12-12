package com.iot.device_event.config;

import com.iot.device_event.stream.BaseDeviceEventsStream;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(BaseDeviceEventsStream.class)
public class KafkaConfig {
}
