package it.objectway.corsi.fssurfer.impl;

import it.objectway.corsi.fssurfer.interfaces.FileManager;
import it.objectway.corsi.fssurfer.interfaces.LogManager;
import it.objectway.corsi.fssurfer.interfaces.Surfer;

import java.nio.file.Path;

/**
 * Created by stageusr2015 on 18/05/2015.
 */
public class SurferImpl implements Surfer {
    private static LogManager logger = new LogManagerImpl(SurferImpl.class);
    private static FileManager fileManager = new FileManagerImpl();

    public void surf(String fileSystemRoot) {
        logger.trace("surf: ", fileSystemRoot);
        Path root = fileManager.getPath(fileSystemRoot);
        fileManager.walkFileTree(root, new SurferVisitor());
    }
}
