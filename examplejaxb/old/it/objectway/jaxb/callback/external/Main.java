package it.objectway.jaxb.callback.external;

import generated.CatalogType;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Main {
	 

	@SuppressWarnings("unchecked")
	public static void main(String[] argv) {
		File xmlDocument = new File("catalog.xml");
		 
		try {
			
			JAXBContext jaxbContext = JAXBContext.newInstance("generated");

			Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
			unMarshaller.setListener(new MyUnmarshallerListener());
			
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
