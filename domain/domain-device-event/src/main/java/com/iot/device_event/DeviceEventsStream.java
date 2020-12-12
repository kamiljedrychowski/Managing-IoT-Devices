package com.iot.device_event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface DeviceEventsStream {
    String BASE_DEVICE_EVENTS_STREAM = "device-events-stream";

    @Input(BASE_DEVICE_EVENTS_STREAM)
    MessageChannel inputStream();
}
