package com.epam.xstack.mqactive;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("/active")
public class ActiveMQRestController {
    private final JmsTemplate jmsTemplate;

    @GetMapping(value="/send/{message}", produces = "text/html")
    public String sendMessage(@PathVariable("message") String message) {
        jmsTemplate.convertAndSend("messagequeue", message);
        return "Message sent successfully!";
    }

}
