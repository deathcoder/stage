package it.objectway.jaxb.marshalling;

import it.objectway.jaxb.common.Indirizzo;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Main {
	private static SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
	public void generateXMLDocument() {
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(Cliente.class);
			Marshaller marshaller = jaxbContext.createMarshaller();

			//Valorizzazione cliente
			Cliente cliente = new Cliente();
			cliente.setNome("Paolo");
			cliente.setCognome("Rossi");
			cliente.setDataDiNascita(SDF.parse("13-11-1973"));
			cliente.setSesso(Sesso.MASCHIO);
			cliente.setCodiceFiscale("RSSPLA70A10F205W");
			
			//Indirizzo
			Indirizzo indirizzo = new Indirizzo();
			indirizzo.setVia("Via Roma");
			indirizzo.setNumeroCivico(90);
			indirizzo.setCitta("Milano");
			indirizzo.setCap("909090");
			indirizzo.setStato("Italia");
			cliente.setIndirizzo(indirizzo);
			
			//Conti Bancari
			Conto conto1 = new Conto();
			conto1.setNumeroConto("123");
			conto1.setSaldo(new Float(1000.454));
			Conto conto2 = new Conto();
			conto2.setNumeroConto("789");
			
			//TipoCliente
			TipoCliente tc = new TipoCliente(1,"TOP", "Cliente VIP");
			cliente.tipoCliente = tc;
			
			//Ultime password
			cliente.setUltimePassword(new HashSet<String>());
			cliente.getUltimePassword().add("123ooo");
			cliente.getUltimePassword().add("pippo");
			
			cliente.setConti(new ArrayList<Conto>());
			cliente.getConti().add(conto1);
			cliente.getConti().add(conto2);
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(cliente, System.out);
			//marshaller.marshal(cliente, new FileOutputStream("cliente.xml"));

		}  catch (JAXBException e) {
			System.out.println(e.toString());

		} catch (Exception pe) {
			System.out.println(pe.toString());
		}

	}

	public static void main(String[] argv) {
		
		Main jaxbMarshaller = new Main();
		jaxbMarshaller.generateXMLDocument();
	}
}
