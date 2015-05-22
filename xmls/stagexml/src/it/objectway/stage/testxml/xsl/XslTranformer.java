package it.objectway.stage.testxml.xsl;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

public class XslTranformer {
	
	
	public static void main(String[] args) {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			
			// Input file
			File datafile = new File("stagexml/resources/xml/testxml/biblioteca.xml");
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(datafile);
			DOMSource source = new DOMSource(document);

			//Transformer
			File stylesheet = new File("stagexml/resources/xml/testxml/biblioteca.xsl");
			TransformerFactory tFactory = TransformerFactory.newInstance();
			StreamSource stylesource = new StreamSource(stylesheet);
			Transformer transformer = tFactory.newTransformer(stylesource);

			//Result
			StreamResult result = new StreamResult(System.out);
//			PrintWriter outStream = new PrintWriter(new FileOutputStream("result"));
//			StreamResult result =  new StreamResult(outStream);

			
			//Trasformazione
			transformer.transform(source, result);


		} catch (TransformerConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (TransformerException e) {
			System.out.println(e.getMessage());
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
