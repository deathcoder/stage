package it.objectway.stage.testxml.xml;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class XmlValidator {

	public static void main(String[] args) {

		File f = new File(".");
		System.out.println(Arrays.asList(f.list()));
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File("stagexml/resources/xml/testxml/biblioteca.xsd"));
			Validator validator = schema.newValidator();
			
			
			validator.validate(new StreamSource(new FileInputStream(new File("stagexml/resources/xml/testxml/biblioteca.xml"))));
			
			System.out.println("DOCUMENTO VALIDO!!");
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
