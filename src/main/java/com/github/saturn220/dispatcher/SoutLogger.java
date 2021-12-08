package com.github.saturn220.dispatcher;

public class SoutLogger implements Logger {

    private String loggerName = "Dispatcher";

    SoutLogger() {}

    SoutLogger(Class<?> loggerName) {
        this.loggerName = loggerName.getSimpleName();
    }

    @Override
    public void info(String msg) {
        System.out.printf("%s. %s.\n", loggerName, msg);
    }

    @Override
    public void warn(String msg) {
        System.err.printf("%s. %s.\n", loggerName, msg);
    }

    @Override
    public void error(String msg) {
        System.err.printf("%s. %s.\n", loggerName, msg);
    }
}
