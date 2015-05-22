package it.objectway.jaxb.validation;

import generated.CatalogType;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

public class Main {
	 

	@SuppressWarnings("unchecked")
	public static void main(String[] argv) {
		File xmlDocument = new File("catalog_incorrect.xml");
		 
		try {
			
			JAXBContext jaxbContext = JAXBContext.newInstance("generated");

			Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
			//Definizione dello schema per validare
			SchemaFactory schemaFactory=SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema"); 
			Schema schema=schemaFactory.newSchema(new File("./gen_source/catalog.xsd")); 
			//Setto lo schema
			unMarshaller.setSchema(schema);
			//Setto il validation handler
			unMarshaller.setEventHandler(new CatalogValidationEventHandler());
			
			JAXBElement<CatalogType> catalogElement = (JAXBElement<CatalogType>) unMarshaller.unmarshal(xmlDocument);
			CatalogType catalog=catalogElement.getValue();

			System.out.println("Section: " + catalog.getSection());
			System.out.println("Publisher: " + catalog.getPublisher());
			
			
		} catch (JAXBException e) {
			System.out.println(e.toString());
		} catch ( Exception ex) {
			System.out.println(ex.toString());
		}
	}
	 

}
