package com.example.orderbook.handler;

import com.example.orderbook.exception.ParsingException;
import com.example.orderbook.model.Event;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderbookManagerImpl implements OrderbookManager {

    private static final Logger logger = LoggerFactory.getLogger(OrderbookManagerImpl.class);

    private final MessageSender messageSender;

    private final ObjectMapper objectMapper;

    private Event subscription;

    public OrderbookManagerImpl(MessageSender messageSender, ObjectMapper objectMapper) {
        this.messageSender = messageSender;
        this.objectMapper = objectMapper;
    }

    @Override
    public void subscribe(Event event) {
        this.subscription = event;
        sendTextMessage(event);
    }

    @Override
    public void unsubscribe(Event event) {
        this.subscription = null;
        sendTextMessage(event);
    }

    private void sendTextMessage(Event event) {
        String msg;
        try {
            msg = objectMapper.writeValueAsString(event);
        } catch (JsonProcessingException e) {
            logger.error("Unable to parse event", e);
            throw new ParsingException();
        }
        messageSender.sendTextMessage(msg);
    }

    @Override
    public Event getSubscription() {
        return subscription;
    }
}
