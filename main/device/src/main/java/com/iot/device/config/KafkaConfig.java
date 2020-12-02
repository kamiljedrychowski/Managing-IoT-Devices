package com.iot.device.config;

import com.iot.device.kafka.stream.BaseDeviceEventsStram;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(BaseDeviceEventsStram.class)
public class KafkaConfig {
}
