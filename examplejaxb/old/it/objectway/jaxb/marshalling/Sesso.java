package it.objectway.jaxb.marshalling;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum Sesso {
	@XmlEnumValue("M")
	MASCHIO,
	@XmlEnumValue("F")
	FEMMINA;

}
