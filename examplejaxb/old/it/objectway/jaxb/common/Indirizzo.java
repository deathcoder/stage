package it.objectway.jaxb.common;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
@XmlType(namespace="http://www.objectway.it/common")
public class Indirizzo {
	private String via;
	private Integer numeroCivico;
	private String citta;
	private String cap;
	private String stato;
	
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getStato() {
		return stato;
	}
	@XmlAttribute
	public void setStato(String stato) {
		this.stato = stato;
	}
	
	public Integer getNumeroCivico() {
		return numeroCivico;
	}
	public void setNumeroCivico(Integer numeroCivico) {
		this.numeroCivico = numeroCivico;	
	}

}
