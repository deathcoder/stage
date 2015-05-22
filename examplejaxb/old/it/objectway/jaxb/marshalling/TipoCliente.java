package it.objectway.jaxb.marshalling;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(value=XmlAccessType.NONE)

public class TipoCliente {
	private int idTipoCliente;
	private String codiceProfilo;
	private String descrizioneProfilo;
	
	public TipoCliente(){};
	
	public TipoCliente(int idTipoCliente, String codiceProfilo,
			String descrizioneProfilo) {
		this.idTipoCliente = idTipoCliente;
		this.codiceProfilo = codiceProfilo;
		this.descrizioneProfilo = descrizioneProfilo;
	}
	public int getIdTipoCliente() {
		return idTipoCliente;
	}
	public void setIdTipoCliente(int idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
	}
	@XmlValue 
	public String getCodiceProfilo() {
		return codiceProfilo;
	}
	public void setCodiceProfilo(String codiceProfilo) {
		this.codiceProfilo = codiceProfilo;
	}
	
	public String getDescrizioneProfilo() {
		return descrizioneProfilo;
	}
	public void setDescrizioneProfilo(String descrizioneProfilo) {
		this.descrizioneProfilo = descrizioneProfilo;
	}
	
	
	

}
