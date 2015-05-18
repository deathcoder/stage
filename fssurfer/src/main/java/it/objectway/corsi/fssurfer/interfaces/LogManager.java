package it.objectway.corsi.fssurfer.interfaces;

/**
 * Created by stageusr2015 on 18/05/2015.
 */
public interface LogManager {
    void debug(Object... messages);

    void error(Object... messages);

    void fatal(Object... messages);

    void info(Object... messages);

    void trace(Object... messages);

    void warn(Object... messages);
}
