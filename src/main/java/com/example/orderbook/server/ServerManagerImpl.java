package com.example.orderbook.server;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.client.WebSocketConnectionManager;

@Service
public class ServerManagerImpl implements ServerManager {

    private final WebSocketConnectionManager wsConnectionManager;

    public ServerManagerImpl(WebSocketConnectionManager wsConnectionManager) {
        this.wsConnectionManager = wsConnectionManager;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        connect();
    }

    @Override
    public void connect() {
        wsConnectionManager.start();
    }

    @Override
    public void disconnect() {
        wsConnectionManager.stop();
    }
}
