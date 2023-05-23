package com.example.orderbook.config;

import com.example.orderbook.handler.MessageHandler;
import com.example.orderbook.handler.WebSocketSessionHandler;
import com.example.orderbook.handler.WebSocketSessionHandlerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@Configuration
@EnableWebSocket
public class WebSocketConfig {

    private final ApplicationProperties.Exchange exchange;

    public WebSocketConfig(ApplicationProperties applicationProperties) {
        this.exchange = applicationProperties.getExchange();
    }

    @Bean
    public WebSocketClient webSocketClient() {
        return new StandardWebSocketClient();
    }

    @Bean
    public WebSocketSessionHandler webSocketSessionHandler(){
        return new WebSocketSessionHandlerImpl();
    }

    @Bean
    public WebSocketHandler webSocketHandler(WebSocketSessionHandler webSocketSessionHandler) {
        return new MessageHandler(webSocketSessionHandler);
    }

    @Bean
    public WebSocketConnectionManager webSocketConnectionManager(WebSocketClient webSocketClient,
                                                                 WebSocketHandler webSocketHandler) {
        return new WebSocketConnectionManager(
                webSocketClient,
                webSocketHandler,
                exchange.getHost());
    }

}
