package it.objectway.corsi.springtest.depinjection.helpers;

import it.objectway.corsi.springtest.depinjection.interfaces.IOutputGenerator;

/**
 * Created by stageusr2015 on 08/06/2015.
 */
public class OutputHelper {
    IOutputGenerator outputGenerator;

    public void generateOutput(){
        outputGenerator.generateOutput();
    }

    public void setOutputGenerator(IOutputGenerator outputGenerator){
        this.outputGenerator = outputGenerator;
    }
}
