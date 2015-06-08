package it.objectway.corsi.springtest.hello;

import it.objectway.corsi.springtest.hello.beans.HelloWorld;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class Main {
    public static void main( String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("hello.xml");

        /*HelloWorld obj = (HelloWorld) context.getBean("hello");*/
        BeanFactory factory = context;
        HelloWorld obj = (HelloWorld) factory.getBean("hello");
        obj.printHello();
    }
}
