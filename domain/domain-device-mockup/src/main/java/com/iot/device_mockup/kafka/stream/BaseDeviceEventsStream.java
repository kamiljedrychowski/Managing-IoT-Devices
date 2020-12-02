package com.iot.device_mockup.kafka.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface BaseDeviceEventsStream {
    String BASE_DEVICE_EVENTS_STREAM = "base-device-events-stream";

    @Input(BASE_DEVICE_EVENTS_STREAM)
    SubscribableChannel inputStream();
}
