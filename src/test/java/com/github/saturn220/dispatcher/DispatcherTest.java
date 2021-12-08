package com.github.saturn220.dispatcher;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class DispatcherTest {

    @Test
    void testNoListenerRegister() {
        Logger logger = mock(Logger.class);

        Dispatcher dispatcher = new Dispatcher();
        dispatcher.logger = logger;
        dispatcher.dispatch("app.domain.event.done");

        verify(logger).info(anyString());
        verify(logger).warn("No listeners. Event: app.domain.event.done");
    }
}