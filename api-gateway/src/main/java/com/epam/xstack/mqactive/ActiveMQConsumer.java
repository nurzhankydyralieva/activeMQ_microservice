package com.epam.xstack.mqactive;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ActiveMQConsumer {
    @JmsListener(destination = "messagequeue")
    public void processMessage(String message) {
        log.info("Message received: " + message);
    }
}
