package it.objectway.jaxb.namespaceprefix;


import javax.xml.bind.*;
import javax.xml.namespace.QName;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

import java.util.List;

public class Main {
	public void generateXMLDocument() {
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance("it.objectway.jaxb.namespaceprefix");
			Marshaller marshaller = jaxbContext.createMarshaller();
			

			CatalogType catalog = new CatalogType();
			catalog.setSection("Java Technology");
			catalog.setPublisher("IBM developerWorks");

			JournalType journal = new JournalType();
			ArticleType article = new ArticleType();

			article.setLevel("Intermediate");
			article.setDate("January-2004");
			article.setTitle("Service Oriented Architecture   Frameworks");
			article.setAuthor("Naveen Balani");

			List<JournalType> journalList = catalog.getJournal();
			journalList.add(journal);
			List<ArticleType> articleList = journal.getArticle();
			articleList.add(article);

			article = new ArticleType();

			article.setLevel("Advanced");
			article.setDate("October-2003");
			article.setTitle("Advance DAO Programming");
			article.setAuthor("Sean Sullivan");

			articleList = journal.getArticle();
			articleList.add(article);

			article = new ArticleType();

			article.setLevel("Advanced");
			article.setDate("May-2002");
			article.setTitle("Best Practices in EJB   Exception Handling");
			article.setAuthor("Srikanth Shenoy");
			articleList = journal.getArticle();

			articleList.add(article);
			JAXBElement<CatalogType> catalogElement= new JAXBElement<CatalogType>(new QName("", "catalog"), CatalogType.class,  catalog);
			marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
			try {
				//Attenzione questa proprieà è supportata solo dalla Reference Implementation!!!
	            marshaller.setProperty(NamespacePrefixMapper.PROPERTY,new NamespacePrefixMapperImpl());
	        } catch( PropertyException e ) {
	            // if the JAXB provider doesn't recognize the prefix mapper,
	            // it will throw this exception. Since being unable to specify
	            // a human friendly prefix is not really a fatal problem,
	            // you can just continue marshalling without failing
	            ;
	        }
			marshaller.marshal(catalogElement, System.out);

		}  catch (JAXBException e) {
			System.out.println(e.toString());

		}

	}

	public static void main(String[] argv) {
		
		Main jaxbMarshaller = new Main();
		jaxbMarshaller.generateXMLDocument();
	}
}
