package com.iot.device_status.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface BaseDeviceEventSinkStream {
    String BASE_DEVICE_EVENTS_STREAM = "base-device-events-stream";

    @Input(BASE_DEVICE_EVENTS_STREAM)
    MessageChannel outputStream();
}
