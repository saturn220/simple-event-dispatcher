package com.github.saturn220.dispatcher;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DispatcherTest {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @BeforeAll
    static void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    static void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testNoListenerRegister() {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.dispatch("app.domain.event.done");

        assertEquals("Dispatcher. Raised event: app.domain.event.done. Data: null\nDispatcher. No listeners. Event: app.domain.event.done\n", outContent.toString());
    }
}