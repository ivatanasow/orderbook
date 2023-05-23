package com.example.orderbook.controller;

import com.example.orderbook.exception.ExceptionTranslator;
import com.example.orderbook.handler.OrderbookManager;
import com.example.orderbook.model.Event;
import com.example.orderbook.model.EventType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderbookController extends ExceptionTranslator {

    private final OrderbookManager orderbookManager;

    public OrderbookController(OrderbookManager orderbookManager) {
        this.orderbookManager = orderbookManager;
    }

    @PostMapping("/subscribe")
    public ResponseEntity<Event> subscribe(@RequestBody Event event) {
        event.setEvent(EventType.SUBSCRIBE);
        orderbookManager.subscribe(event);

        return ResponseEntity.ok(event);
    }

    @PostMapping("/unsubscribe")
    public ResponseEntity<Event> unsubscribe(@RequestBody Event event) {
        event.setEvent(EventType.UNSUBSCRIBE);
        orderbookManager.unsubscribe(event);

        return ResponseEntity.ok(event);
    }

    @GetMapping("/subscription")
    public ResponseEntity<Event> getSubscription(){
        return ResponseEntity.ok(orderbookManager.getSubscription());
    }

}
