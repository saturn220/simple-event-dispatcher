package com.github.saturn220.dispatcher;

public interface Logger {

    /**
     * Log a message at the INFO level.
     *
     * @param msg the message string to be logged
     */
    public void info(String msg);

    /**
     * Log a message at the WARNING level.
     *
     * @param msg the message string to be logged
     */
    public void warn(String msg);

    /**
     * Log a message at the ERROR level.
     *
     * @param msg the message string to be logged
     */
    public void error(String msg);
}
