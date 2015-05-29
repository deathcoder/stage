package it.objectway.corsi.ecommerce.impl;

import it.objectway.corsi.ecommerce.interfaces.LogManager;
import org.apache.log4j.Logger;

import static org.apache.log4j.Level.*;
import static it.objectway.corsi.ecommerce.utils.Strings.buildString;

/**
 * Created by stageusr2015 on 29/05/2015.
 */
public class LogManagerImpl implements LogManager {
    private Logger logger;

    public LogManagerImpl(Class<?> c) {
        setLogger(c);
    }

    public void debug(Object... messages) {
        if (logger.isEnabledFor(DEBUG)) {
            logger.debug(buildString(messages));
        }
    }

    public void error(Object... messages) {
        if (logger.isEnabledFor(ERROR)) {
            logger.error(buildString(messages));
        }
    }

    public void fatal(Object... messages) {
        if (logger.isEnabledFor(FATAL)) {
            logger.fatal(buildString(messages));
        }
    }

    public void info(Object... messages) {
        if (logger.isEnabledFor(INFO)) {
            logger.info(buildString(messages));
        }
    }

    public void trace(Object... messages) {
        if (logger.isEnabledFor(TRACE)) {
            logger.trace(buildString(messages));
        }
    }

    public void warn(Object... messages) {
        if (logger.isEnabledFor(WARN)) {
            logger.warn(buildString(messages));
        }
    }

    private void setLogger(Class<?> c) {
        logger = Logger.getLogger(c);
    }
}

