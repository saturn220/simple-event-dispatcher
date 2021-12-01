package com.github.saturn220.dispatcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Dispatcher provides tools that allow your application
 * modules(components) to communicate with each other by dispatching events and listening to
 * them.
 *
 * @author Stanislav Aliferovich
 * @since 06.05.2020
 */
public class Dispatcher {

    private final Map<String, List<Listener>> eventToListeners = new HashMap<>();

    /**
     * Register a new listener for an event.
     */
    public void register(String eventName, Listener listener) {
        // todo: replace list to set and remove non relevant listeners.
        List<Listener> list = eventToListeners.get(eventName);
        if (list == null) {
            list = new ArrayList<>();
            eventToListeners.put(eventName, list);
        }

        list.add(listener);
    }

    public void dispatch(Event event) {
        dispatch(event.getName(), event.getData());
    }

    public void dispatch(String event) {
        dispatch(event, null);
    }

    public void dispatch(String eventName, EventData eventData) {
        System.out.println("Dispatcher. Raised event: " + eventName + ". Data: " + eventData);

        if (eventToListeners.get(eventName) == null) {
            System.out.println("Dispatcher. No listeners. Event: " + eventName);
            return;
        }

        for (Listener listener : eventToListeners.get(eventName)) {
            listener.handle(eventData);
        }
    }

    public List<Listener> getEventListeners(String eventName) {
        return eventToListeners.get(eventName);
    }
}