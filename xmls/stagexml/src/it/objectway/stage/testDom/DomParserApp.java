package it.objectway.stage.testDom;

import org.w3c.dom.*;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by stageusr2015 on 20/05/2015.
 */
public class DomParserApp {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            File xml = new File("stagexml/resources/xml/testdom/catalog.xml");
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xml);
            serialize(document);
            System.out.println();
            Element root = document.getDocumentElement();
            System.out.println("Root element: " + root.getTagName());
            visitNode(null, root);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void visitNode(Element previous, Element visit) {
        if(previous != null) {
            System.out.println("Element: " + previous.getTagName() + " has elements:");
        }
        System.out.println("Element name: " + visit.getTagName());

        if(visit.hasAttributes()) {
            System.out.println("Element " + visit.getTagName() + " has attributes:");
            NamedNodeMap attributes = visit.getAttributes();
            for(int i = 0; i < attributes.getLength(); i++) {
                Attr attribute = (Attr) attributes.item(i);
                String format = "  Attribute name: %s, Attribute value: %s";
                System.out.println(String.format(format, attribute.getName(), attribute.getValue()));
            }
        }
        NodeList list = visit.getChildNodes();
        for(int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                visitNode(visit, element);
            } else if (node.getNodeType() == Node.TEXT_NODE) {
                String str = node.getNodeValue().trim();
                if(str.length() > 0) {
                    System.out.println("Element text: " + str);
                }
            }
        }
    }

    public static void serialize(Document doc) {
        DOMImplementationLS ls = (DOMImplementationLS) doc.getImplementation();
        LSOutput out = ls.createLSOutput();
        out.setCharacterStream(new PrintWriter(System.out));
        LSSerializer serializer = ls.createLSSerializer();
        serializer.write(doc, out);
    }
}
