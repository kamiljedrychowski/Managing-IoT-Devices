package com.iot.device_event;

import com.iot.device_event.entity.DeviceEvent;
import com.iot.device_event.stream.BaseDeviceEventsStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
@Slf4j
public class BaseDeviceEventProducer {

    private final BaseDeviceEventsStream stream;

    public BaseDeviceEventProducer(BaseDeviceEventsStream stream) {
        this.stream = stream;
    }

    public void sendBaseDeviceEvent(DeviceEvent deviceEvent) {
        MessageChannel messageChannel = stream.outputStream();
        messageChannel.send(MessageBuilder
                .withPayload(deviceEvent)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());

        log.info("base_device_event sent: {}", deviceEvent);
    }

}
