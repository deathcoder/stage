package it.objectway.jaxb.marshalling;

import javax.xml.bind.annotation.XmlElement;

public class Conto {
	private String numeroConto;
	private Float saldo;
	
	public String getNumeroConto() {
		return numeroConto;
	}
	public void setNumeroConto(String numeroConto) {
		this.numeroConto = numeroConto;
	}
	@XmlElement(nillable=true)
	public Float getSaldo() {
		return saldo;
	}
	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}
	
	

}
