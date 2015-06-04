package it.objectway.corsi.hibtest.interfaces;

/**
 * Created by stageusr2015 on 29/05/2015.
 */
public interface LogManager {
    void debug(Object... messages);

    void error(Object... messages);

    void fatal(Object... messages);

    void info(Object... messages);

    void trace(Object... messages);

    void warn(Object... messages);
}
