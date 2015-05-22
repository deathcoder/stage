package it.objectway.stage.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by stageusr2015 on 21/05/2015.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use= SOAPBinding.Use.LITERAL) //optional
public interface HelloWorld {
    @WebMethod
    String getHelloWorldAsString(String name);
}