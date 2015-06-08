package it.objectway.corsi.springtest.depinjection.impl;

import it.objectway.corsi.springtest.depinjection.interfaces.IOutputGenerator;

/**
 * Created by stageusr2015 on 08/06/2015.
 */
public class CsvOutputGenerator implements IOutputGenerator {
    public void generateOutput() {
        System.out.println("Csv Output Generator");
    }
}
