package com.github.saturn220.dispatcher;

import com.github.saturn220.dispatcher.fake.MyDataObject;
import com.github.saturn220.dispatcher.fake.MyEvent;
import com.github.saturn220.dispatcher.fake.MyListener;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DispatcherFuncTest {

    @Test
    void dispatchCustomEvent() {
        Dispatcher dispatcher = new Dispatcher();
        MyListener myListener = new MyListener();
        dispatcher.register(MyEvent.NAME, myListener);

        dispatcher.dispatch(new MyEvent());

        assertEquals(10, myListener.value);
    }

    @Test
    void dispatchRegisteredListener() {
        MyListener myListener = new MyListener();
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.register("app.domain.entity.updated", myListener);

        MyDataObject dataObject = new MyDataObject();

        dispatcher.dispatch("app.domain.entity.updated", new EventData(dataObject));

        assertEquals(myListener.value, dataObject.value);
    }

    @Test
    void dispatchAnnotatedListener() {
        Dispatcher dispatcher = new Dispatcher();
        assertNull(dispatcher.getEventListeners("app.domain.entity.updated"));

        DispatcherRegistrar.registerListeners(dispatcher, "com.github.saturn220.dispatcher");

        MyDataObject dataObject = new MyDataObject();

        dispatcher.dispatch("app.domain.entity.updated", new EventData(dataObject));

        List<Listener> listeners = dispatcher.getEventListeners("app.domain.entity.updated");
        assertNotNull(listeners);
        assertEquals(1, listeners.size());
    }
}