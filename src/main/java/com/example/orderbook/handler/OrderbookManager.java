package com.example.orderbook.handler;

import com.example.orderbook.model.Event;

public interface OrderbookManager {

    void subscribe(Event event);

    void unsubscribe(Event event);

    Event getSubscription();

}
