package com.iot.device.kafka;

import com.iot.device.kafka.entity.DeviceEvent;
import com.iot.device.kafka.stream.BaseDeviceEventsStram;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
@Slf4j
public class BaseDeviceEventProducer {

    private final BaseDeviceEventsStram stream;

    public BaseDeviceEventProducer(BaseDeviceEventsStram stream) {
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
