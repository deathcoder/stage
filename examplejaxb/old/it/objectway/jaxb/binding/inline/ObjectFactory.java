//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.07.30 at 02:29:11 PM CEST 
//


package it.objectway.jaxb.binding.inline;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.objectway.jaxb.binding.inline package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Article_QNAME = new QName("", "article");
    private final static QName _Journal_QNAME = new QName("", "journal");
    private final static QName _Catalog_QNAME = new QName("", "catalog");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.objectway.jaxb.binding.inline
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AAJournalTypeGG }
     * 
     */
    public AAJournalTypeGG createAAJournalTypeGG() {
        return new AAJournalTypeGG();
    }

    /**
     * Create an instance of {@link Catalogo }
     * 
     */
    public Catalogo createCatalogo() {
        return new Catalogo();
    }

    /**
     * Create an instance of {@link AAArticleTypeGG }
     * 
     */
    public AAArticleTypeGG createAAArticleTypeGG() {
        return new AAArticleTypeGG();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AAArticleTypeGG }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "article")
    public JAXBElement<AAArticleTypeGG> createArticle(AAArticleTypeGG value) {
        return new JAXBElement<AAArticleTypeGG>(_Article_QNAME, AAArticleTypeGG.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AAJournalTypeGG }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "journal")
    public JAXBElement<AAJournalTypeGG> createJournal(AAJournalTypeGG value) {
        return new JAXBElement<AAJournalTypeGG>(_Journal_QNAME, AAJournalTypeGG.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Catalogo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "catalog")
    public JAXBElement<Catalogo> createCatalog(Catalogo value) {
        return new JAXBElement<Catalogo>(_Catalog_QNAME, Catalogo.class, null, value);
    }

}
