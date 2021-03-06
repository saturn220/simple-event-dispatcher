package com.github.saturn220.dispatcher;

import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.Set;

/**
 * @author Stanislav Aliferovich
 * @since 08.07.2020
 */
public class DispatcherRegistrar {

    public static void registerListeners(Dispatcher dispatcher, String prefix) {
        Reflections reflections = new Reflections(prefix);

        Set<Class<? extends Listener>> eventListeners = reflections.getSubTypesOf(Listener.class);
        for (Class<?> clazz : eventListeners) {
            Annotation annotation = clazz.getAnnotation(EventListener.class);
            if (Modifier.isAbstract(clazz.getModifiers())) {
                continue;
            }
            if (annotation == null) {
                dispatcher.logger.warn("EventHandler annotate not defined for event listener class: " + clazz);
            }
        }

        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(EventListener.class);
        for (Class<?> clazz : annotated) {
            if (!Listener.class.isAssignableFrom(clazz)) {
                dispatcher.logger.warn("Class is not implemented interface Listener: " + clazz);
                continue;
            }

            EventListener annotation = clazz.getAnnotation(EventListener.class);

            try {
                Listener listener = (Listener) clazz.newInstance();
                dispatcher.register(annotation.value(), listener);

                dispatcher.logger.info("Registered listener for event: " + annotation.value());
            } catch (InstantiationException | IllegalAccessException e) {
                dispatcher.logger.error(e.getMessage());
            }
        }
    }
}
