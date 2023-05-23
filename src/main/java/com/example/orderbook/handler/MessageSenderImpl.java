package com.example.orderbook.handler;

import com.example.orderbook.exception.InternalServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class MessageSenderImpl implements MessageSender {

    private static final Logger logger = LoggerFactory.getLogger(MessageSender.class);

    private final WebSocketSessionHandler webSocketSessionHandler;

    public MessageSenderImpl(WebSocketSessionHandler webSocketSessionHandler) {
        this.webSocketSessionHandler = webSocketSessionHandler;
    }

    @Override
    public void sendTextMessage(String message) {
        TextMessage textMessage = new TextMessage(message.getBytes(StandardCharsets.UTF_8));
        try {
            WebSocketSession webSocketSession = webSocketSessionHandler.getWebSocketSession();
            webSocketSession.sendMessage(textMessage);
        } catch (IOException e) {
            logger.error("Unable to send websocket message", e);
            throw new InternalServerException();
        }
    }
}
