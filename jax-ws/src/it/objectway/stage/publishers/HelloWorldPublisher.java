package it.objectway.stage.publishers;

import it.objectway.stage.endpoints.HelloWorldImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by stageusr2015 on 21/05/2015.
 */
public class HelloWorldPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());
    }
}
