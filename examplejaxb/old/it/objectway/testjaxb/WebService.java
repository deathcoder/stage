package it.objectway.testjaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Created by stageusr2015 on 20/05/2015.
 */
public class WebService {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance("generated");
            Marshaller marshaller = jaxbContext.createMarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
