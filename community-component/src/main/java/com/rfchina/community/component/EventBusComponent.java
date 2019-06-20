package com.rfchina.community.component;

import com.google.common.eventbus.EventBus;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class EventBusComponent {

    private final ConcurrentHashMap<String, EventBus> eventBusCacheMap = new ConcurrentHashMap<>();

    public EventBus getEventBus(String name) {
        if(eventBusCacheMap.containsKey(name)) {
            return eventBusCacheMap.get(name);
        }
        EventBus eventBus = new EventBus(name);
        eventBusCacheMap.put(name, eventBus);
        return eventBus;
    }
}
