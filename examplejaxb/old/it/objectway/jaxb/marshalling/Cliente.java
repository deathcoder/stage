package it.objectway.jaxb.marshalling;

import it.objectway.jaxb.common.Indirizzo;
import it.objectway.jaxb.common.XmlDataAdapter;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="cliente-bancario",namespace="http://www.objectway.it/bank")
@XmlType(propOrder={"nome","cognome","indirizzo","dataDiNascita","sesso","conti","tipoCliente","ultimePassword"})

public class Cliente {
	private String nome;
	private String cognome;
	private Sesso sesso;
	private Date dataDiNascita;
	private String codiceFiscale;
	private Indirizzo indirizzo;
	private List<Conto> conti;
	public  TipoCliente tipoCliente;
	private Set<String> ultimePassword;
	  
	
	@XmlTransient
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	@XmlJavaTypeAdapter(value=XmlDataAdapter.class)
	@XmlElement(name="data-nascita")
	public Date getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public Indirizzo getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}
	@XmlElementWrapper(name="lista-conti")
	@XmlElement(name="conto")
	public List<Conto> getConti() {
		return conti;
	}
	public void setConti(List<Conto> conti) {
		this.conti = conti;
	}
	public Sesso getSesso() {
		return sesso;
	}
	public void setSesso(Sesso sesso) {
		this.sesso = sesso;
	}
	@XmlList
	public Set<String> getUltimePassword() {
		return ultimePassword;
	}
	public void setUltimePassword(Set<String> ultimePassword) {
		this.ultimePassword = ultimePassword;
	}
	
	
}
