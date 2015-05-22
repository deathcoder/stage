package it.objectway.stage.testsax;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by stageusr2015 on 20/05/2015.
 */
public class SaxParserApp {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        /*factory.setNamespaceAware(true);*/
        SAXParser saxParser = null;
        try {
            saxParser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        XMLReader xmlReader = null;
        try {
            xmlReader = saxParser.getXMLReader();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        xmlReader.setContentHandler(new CustomSaxHandler());
        xmlReader.setErrorHandler(new CustomErrorHandler(System.err));
        try {
            xmlReader.parse(convertToFileURL("stagexml/resources/xml/testsax/catalog.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static String convertToFileURL(String filename) {
        String path = new File(filename).getAbsolutePath();
        if (File.separatorChar != '/') {
            path = path.replace(File.separatorChar, '/');
        }

        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        return "file:" + path;
    }

}
