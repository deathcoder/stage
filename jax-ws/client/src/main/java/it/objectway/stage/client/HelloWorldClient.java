package it.objectway.stage.client;

import it.objectway.stage.endpoints.HelloWorldImplService;

/**
 * Created by stageusr2015 on 21/05/2015.
 */
public class HelloWorldClient {
    public static void main(String[] args) throws Exception {

        /*URL url = new URL("http://localhost:9999/ws/hello?wsdl");
        QName qname = new QName("http://endpoints.stage.objectway.it/", "HelloWorldImplService");

        Service service = Service.create(url, qname);

        HelloWorld hello = service.getPort(HelloWorld.class);

        System.out.println(hello.getHelloWorldAsString("stageusr"));

*/
        HelloWorldImplService service1 = new HelloWorldImplService();
        System.out.println(service1.getHelloWorldImplPort().getHelloWorldAsString("stageusr2"));

    }
}
