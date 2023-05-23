package com.example.orderbook.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MessageHandler extends TextWebSocketHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final WebSocketSessionHandler webSocketSessionHandler;

    public MessageHandler(WebSocketSessionHandler webSocketSessionHandler) {
        this.webSocketSessionHandler = webSocketSessionHandler;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        this.webSocketSessionHandler.registerWebSocketSession(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        logger.info(message.getPayload());
    }

}
