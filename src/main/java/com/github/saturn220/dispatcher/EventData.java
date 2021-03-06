package com.github.saturn220.dispatcher;

import java.io.Serializable;

/**
 * Container of event data transmitted to listeners.
 *
 * @author Stanislav Aliferovich
 * @since 06.05.2020
 */
public class EventData implements Serializable {
    protected Object value;
    protected Object value2;
    protected Object value3;

    protected EventData() {}

    public EventData(Object value) {
        this.value = value;
    }

    public EventData(Object value1, Object value2) {
        this.value = value1;
        this.value2 = value2;
    }

    public EventData(Object value1, Object value2, Object value3) {
        this.value = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    @SuppressWarnings("unchecked")
    public <T> T get() {
        return (T) value;
    }

    @SuppressWarnings("unchecked")
    public <T> T get2() {
        return (T) value2;
    }

    @SuppressWarnings("unchecked")
    public <T> T get3() {
        return (T) value3;
    }

    public <T> T get(Class<T> clazz) {
        return cast(clazz, value);
    }

    public <T> T get2(Class<T> clazz) {
        return cast(clazz, value2);
    }

    public <T> T get3(Class<T> clazz) {
        return cast(clazz, value3);
    }

    private <T> T cast(Class<T> clazz, Object value) {
        if (!clazz.isInstance(value)) {
            System.err.println("Dispatcher. Cannot cast to: " + clazz);
            return null;
        }

        return clazz.cast(value);
    }

    private String toStringIsNotNull(Object obj) {
        return toStringIsNotNull(obj, "");
    }

    private String toStringIsNotNull(Object obj, String separator) {
        if (obj == null) return "";

        return separator + obj;
    }

    @Override
    public String toString() {
        return toStringIsNotNull(value) + toStringIsNotNull(value2, ":") + toStringIsNotNull(value3, ":");
    }
}
