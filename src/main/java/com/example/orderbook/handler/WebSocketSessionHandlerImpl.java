package com.example.orderbook.handler;

import org.springframework.web.socket.WebSocketSession;

public class WebSocketSessionHandlerImpl implements WebSocketSessionHandler {

    private WebSocketSession webSocketSession;

    public WebSocketSession getWebSocketSession() {
        return webSocketSession;
    }

    @Override
    public void registerWebSocketSession(WebSocketSession webSocketSession) {
        this.webSocketSession = webSocketSession;
    }
}
