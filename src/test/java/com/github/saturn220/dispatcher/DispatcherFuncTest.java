package com.github.saturn220.dispatcher;

import com.github.saturn220.dispatcher.fake.MyDataObject;
import com.github.saturn220.dispatcher.fake.MyListener;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DispatcherFuncTest {

    @Test
    void dispatch() {
        MyListener myListener = new MyListener();
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.register("my-event", myListener);

        MyDataObject dataObject = new MyDataObject();

        dispatcher.dispatch("my-event", new EventData(dataObject));

        assertEquals(myListener.value, dataObject.value);
    }

    @Test
    void dispatchAnnotatedListener() {
        Dispatcher dispatcher = new Dispatcher();
        assertNull(dispatcher.getEventListeners("my-event"));

        DispatcherRegistrar.registerListeners(dispatcher, "com.github.saturn220.dispatcher");

        MyDataObject dataObject = new MyDataObject();

        dispatcher.dispatch("my-event", new EventData(dataObject));

        List<Listener> listeners = dispatcher.getEventListeners("my-event");
        assertNotNull(listeners);
        assertEquals(1, listeners.size());
    }
}