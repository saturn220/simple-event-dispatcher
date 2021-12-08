package com.github.saturn220.dispatcher;

public class NullLogger implements Logger {

    @Override
    public void info(String msg) {}

    @Override
    public void warn(String msg) {}

    @Override
    public void error(String msg) {}
}
