package it.objectway.corsi.springtest.depinjection.impl;

import it.objectway.corsi.springtest.depinjection.interfaces.IOutputGenerator;

/**
 * Created by stageusr2015 on 08/06/2015.
 */
public class JsonOutputGenerator implements IOutputGenerator {
    public void generateOutput() {
        System.out.println("Json Output Generator");
    }
}
