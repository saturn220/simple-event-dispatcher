package com.github.saturn220.dispatcher;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EventDataTest {

    @Test
    void testGet() {
        EventData data = new EventData(1);
        int value = data.get();
        assertEquals(1, value);
    }

    @Test
    void testGet2() {
        EventData data = new EventData(1, 2);
        int value1 = data.get();
        int value2 = data.get2();
        assertEquals(1, value1);
        assertEquals(2, value2);
    }

    @Test
    void testGet3() {
        EventData data = new EventData(1, 2, 3);
        int value1 = data.get();
        int value2 = data.get2();
        int value3 = data.get3();
        assertEquals(1, value1);
        assertEquals(2, value2);
        assertEquals(3, value3);
    }

    @Test
    void testGetWithCast() {
        EventData data = new EventData(1);
        assertEquals(1, data.get(Integer.class));
    }

    @Test
    void testGet2WithCast() {
        EventData data = new EventData(1, 2);
        assertEquals(1, data.get(Integer.class));
        assertEquals(2, data.get2(Integer.class));
    }

    @Test
    void testGet3WithCast() {
        EventData data = new EventData(1, 2, 3);
        assertEquals(1, data.get(Integer.class));
        assertEquals(2, data.get2(Integer.class));
        assertEquals(3, data.get3(Integer.class));
    }


    @Test
    void testToString() {
        assertEquals("1:2:3", new EventData(1, 2, 3).toString());
    }

    @Test
    void testCastError() {
        EventData data = new EventData(1);

        assertNull(data.get(String.class));
    }
}