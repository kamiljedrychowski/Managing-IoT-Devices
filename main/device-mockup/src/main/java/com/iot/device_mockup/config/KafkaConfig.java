package com.iot.device_mockup.config;

import com.iot.device_mockup.kafka.stream.MockDeviceStream;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(MockDeviceStream.class)
public class KafkaConfig {
}
