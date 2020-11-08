package com.iot.device_status.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface DeviceStatusSinkStream {
    String DEVICE_STATUS_SINK_STREAM = "device-status-sink-stream";

    @Input(DEVICE_STATUS_SINK_STREAM)
    SubscribableChannel inputStream();
}
