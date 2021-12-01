package com.github.saturn220.dispatcher;

public interface Event {

    String getName();

    default EventData getData() {
        return null;
    }
}
