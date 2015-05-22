package it.objectway.stage.endpoints;

import it.objectway.stage.interfaces.HelloWorld;

import javax.jws.WebService;

/**
 * Created by stageusr2015 on 21/05/2015.
 */
@WebService(endpointInterface = "it.objectway.stage.interfaces.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String getHelloWorldAsString(String name) {
        return "Hello World JAX-WS " + name;
    }
}
