package it.objectway.corsi.springtest.hello.beans;

/**
 * Created by stageusr2015 on 08/06/2015.
 */
public class HelloWorld {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void printHello() {
        System.out.println("Hello ! " + name);
    }
}
