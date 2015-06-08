package it.objectway.corsi.springtest.depinjection;

import it.objectway.corsi.springtest.depinjection.helpers.OutputHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by stageusr2015 on 08/06/2015.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"depinjection.xml"});

        OutputHelper output = (OutputHelper)context.getBean("OutputHelper");
        output.generateOutput();
    }
}
