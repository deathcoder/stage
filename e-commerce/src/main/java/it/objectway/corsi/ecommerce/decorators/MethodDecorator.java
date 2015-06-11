package it.objectway.corsi.ecommerce.decorators;

import it.objectway.corsi.ecommerce.impl.LogManagerImpl;
import it.objectway.corsi.ecommerce.interfaces.LogManager;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by stageusr2015 on 10/06/2015.
 */
public class MethodDecorator {
    private static final LogManager logger = new LogManagerImpl(MethodDecorator.class);
    public Object log(ProceedingJoinPoint call) throws Throwable {
        logger.trace("args: ", call.getArgs());
        logger.trace("target: ", call.getTarget());
        logger.trace("long: ", call.toLongString());
        logger.trace("short: ", call.toShortString());
        Object result = call.proceed();
        logger.trace("string: ", call.toString());
        return result;
    }
    public void callme() {
        logger.trace("fuuuuuuuuuuuuuuuuuuuuuuuuuuu");
    }
}
