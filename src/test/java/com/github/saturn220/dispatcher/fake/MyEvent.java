package com.github.saturn220.dispatcher.fake;

import com.github.saturn220.dispatcher.Event;

public class MyEvent implements Event {

    public static final String NAME = "my-app.my-domain.my-custom-event.happens";

    @Override
    public String getName() {
        return NAME;
    }
}
