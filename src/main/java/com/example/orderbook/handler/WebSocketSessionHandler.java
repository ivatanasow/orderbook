package com.example.orderbook.handler;

import org.springframework.web.socket.WebSocketSession;

public interface WebSocketSessionHandler {

    WebSocketSession getWebSocketSession();

    void registerWebSocketSession(WebSocketSession webSocketSession);

}
