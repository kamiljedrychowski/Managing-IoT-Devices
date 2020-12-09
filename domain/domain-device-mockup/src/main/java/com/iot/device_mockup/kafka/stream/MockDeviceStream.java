package com.iot.device_mockup.kafka.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MockDeviceStream {
    String BASE_DEVICE_EVENTS_STREAM_INPUT = "base-device-events-stream-input";
    String BASE_DEVICE_EVENTS_STREAM_OUTPUT = "device-status-stream-output";

    @Input(BASE_DEVICE_EVENTS_STREAM_INPUT)
    SubscribableChannel inputStream();

    @Output(BASE_DEVICE_EVENTS_STREAM_OUTPUT)
    MessageChannel output();
}
