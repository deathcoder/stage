package it.objectway.corsi.fssurfer;

import it.objectway.corsi.fssurfer.impl.LogManagerImpl;
import it.objectway.corsi.fssurfer.impl.SurferImpl;
import it.objectway.corsi.fssurfer.interfaces.LogManager;
import it.objectway.corsi.fssurfer.interfaces.Surfer;

/**
 * Created by stageusr2015 on 18/05/2015.
 */
public class Main {
    private static LogManager logger = new LogManagerImpl(Main.class);

    public static void main(String[] args) {
        logger.trace("Main started");
        String root = "C:\\Users\\stageusr2015\\Downloads";
        if(args.length < 1) {
            logger.warn("Usage: java Main <file_system_path> -> Using default configuration");
        }
        else {
            root = args[0];
        }
        Surfer surfer = new SurferImpl();
        surfer.surf(root);
    }
}
