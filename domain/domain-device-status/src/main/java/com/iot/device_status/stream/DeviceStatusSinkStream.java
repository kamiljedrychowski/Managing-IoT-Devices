package com.iot.device_status.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface DeviceStatusSinkStream {
    String DEVICE_STATUS_SINK_STREAM = "device-status-sink-stream";

    @Input(DEVICE_STATUS_SINK_STREAM)
    MessageChannel outputStream();
}
