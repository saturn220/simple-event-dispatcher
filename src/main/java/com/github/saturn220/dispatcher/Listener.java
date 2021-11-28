package com.github.saturn220.dispatcher;

/**
 * @author Stanislav Aliferovich
 * @since 06.05.2020
 */
public interface Listener {
    void handle(EventData eventData);
}
