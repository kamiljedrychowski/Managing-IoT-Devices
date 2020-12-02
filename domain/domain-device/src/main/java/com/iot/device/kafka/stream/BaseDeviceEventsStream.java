package com.iot.device.kafka.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface BaseDeviceEventsStream {
    String BASE_DEVICE_EVENTS_STREAM = "base-device-events-stream";

    @Output(BASE_DEVICE_EVENTS_STREAM)
    SubscribableChannel outputStream();
}
