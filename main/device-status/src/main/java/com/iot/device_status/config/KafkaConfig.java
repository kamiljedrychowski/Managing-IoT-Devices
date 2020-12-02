package com.iot.device_status.config;

import com.iot.device_status.stream.BaseDeviceEventSinkStream;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({BaseDeviceEventSinkStream.class})
public class KafkaConfig {
}
