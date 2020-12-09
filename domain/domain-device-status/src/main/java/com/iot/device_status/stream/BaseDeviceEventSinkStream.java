package com.iot.device_status.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface BaseDeviceEventSinkStream {
    String BASE_DEVICE_EVENTS_STREAM = "device-events-history-input-stream";
    String DEVICE_STATUS_STREAM = "device-status-history-input-stream";

    @Input(BASE_DEVICE_EVENTS_STREAM)
    MessageChannel inputStream();

    @Input(DEVICE_STATUS_STREAM)
    MessageChannel inputStatusStream();
}
