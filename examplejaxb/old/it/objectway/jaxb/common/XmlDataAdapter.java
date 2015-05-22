package it.objectway.jaxb.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class XmlDataAdapter extends XmlAdapter<String,Date> {
	private static SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
	@Override
	public String marshal(Date data) throws Exception {
		return SDF.format(data);
	}

	@Override
	public Date unmarshal(String s) throws Exception {
		return SDF.parse(s);
	}

}
