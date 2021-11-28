package com.github.saturn220.dispatcher;

/**
 * @author Stanislav Aliferovich
 * @since 06.05.2020
 */
public class EventData {
    Object value;
    Object value2;
    Object value3;

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
            System.err.println("Dispatcher - " + getClass().getSimpleName() + ". Cannot cast to: " + clazz);
            return null;
        }

        return clazz.cast(value);
    }

    private String toStringIsNotNull(Object obj) {
        if (obj == null) return "";

        return " : " + obj.toString();
    }

    @Override
    public String toString() {
        return value.toString() + toStringIsNotNull(value2) + toStringIsNotNull(value3);
    }
}
