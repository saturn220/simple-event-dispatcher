package com.github.saturn220.dispatcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Stanislav Aliferovich
 * @since 06.05.2020
 */
public class Dispatcher {

    private final Map<String, List<Listener>> map = new HashMap<>();

    public void register(EventName event, Listener listener) {
        register(event.value, listener);
    }

    public void register(String eventName, Listener listener) {
        // todo: replace list to set and remove non relevant listeners.
        List<Listener> list = map.get(eventName);
        if (list == null) {
            list = new ArrayList<>();
            map.put(eventName, list);
        }

        list.add(listener);
    }

    public void dispatch(EventName event, EventData eventData) {
        dispatch(event.value, eventData);
    }

    public void dispatch(EventName event) {
        dispatch(event, null);
    }

    public void dispatch(String eventName, EventData eventData) {
        System.out.println("Dispatcher - " + getClass().getSimpleName() + ". Raised event: " + eventName + ". Data: " + eventData);

        if (map.get(eventName) == null) {
            System.out.println("Dispatcher - " + getClass().getSimpleName() + ". No listeners. Event: " + eventName);
            return;
        }

        for (Listener listener : map.get(eventName)) {
            listener.handle(eventData);
        }
    }

    public List<Listener> getEventListeners(String eventName) {
        return map.get(eventName);
    }
}