package com.iot.device_mockup.kafka;

import com.iot.device_mockup.kafka.stream.MockDeviceStream;
import com.iot.device_status.entity.DeviceStatus;
import com.iot.device_status.kafka_entity.DeviceStatusKafka;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

@Component
@Slf4j
public class DeviceStatusProducer {

    private final MockDeviceStream mockDeviceStream;

    public DeviceStatusProducer(MockDeviceStream mockDeviceStream) {
        this.mockDeviceStream = mockDeviceStream;
    }

    void send(DeviceStatusKafka subsystemSpotStates) {
        Message<DeviceStatusKafka> message = MessageBuilder
                .withPayload(subsystemSpotStates)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build();
        MessageChannel messageChannel = mockDeviceStream.output();
        messageChannel.send(message);
        log.debug("Send : {}", subsystemSpotStates);
    }
}
