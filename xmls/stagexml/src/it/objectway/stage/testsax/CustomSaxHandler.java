package it.objectway.stage.testsax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by stageusr2015 on 20/05/2015.
 */
public class CustomSaxHandler extends DefaultHandler{
    @Override
    public void startDocument() throws SAXException {
        System.out.println("EventType: Start Document");
        /*super.startDocument();*/
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("EventType: End Document");
        /*super.endDocument();*/
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("EventType: Start Element");
        for(int i = 0; i < attributes.getLength(); i++) {
            System.out.println("Attribute name: " + attributes.getQName(i));
            System.out.println("Attribute value: " + attributes.getValue(i));
        }
        /*super.startElement(uri, localName, qName, attributes);*/
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("EventType: End Element");
        /*super.endElement(uri, localName, qName);*/
    }
}
