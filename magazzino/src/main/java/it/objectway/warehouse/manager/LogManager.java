package it.objectway.warehouse.manager;

import org.apache.log4j.Logger;

/**
 * Created by stageusr2015 on 15/05/2015.
 */
public class LogManager {
    public static void info(Class<?> c, Object message) {
        Logger log = Logger.getLogger(c);
        if(log.isInfoEnabled()) {
            log.info(message);
        }
    }

    public static void debug(Class<?> c, Object message) {
        Logger log = Logger.getLogger(c);
        if(log.isDebugEnabled()) {
            log.debug(message);
        }
    }

    public static void error(Class<?> c, Object message) {
        Logger log = Logger.getLogger(c);
        log.error(message);
    }
}
