package it.objectway.corsi.fssurfer.impl;

import it.objectway.corsi.fssurfer.commands.DatabaseInsertCommand;
import it.objectway.corsi.fssurfer.interfaces.DataBaseManager;
import it.objectway.corsi.fssurfer.interfaces.LogManager;
import it.objectway.corsi.fssurfer.models.FileModel;
import it.objectway.corsi.fssurfer.utils.FileModels;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by stageusr2015 on 18/05/2015.
 */
public class SurferVisitor implements FileVisitor<Path> {
    private static LogManager logger = new LogManagerImpl(SurferVisitor.class);
    private static DataBaseManager dbManager = new DataBaseManagerImpl();

    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        logger.trace("preVisitDirectory: ", dir);
        extractAndInsert(dir);
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        logger.trace("preVisitFile: ", file);
        extractAndInsert(file);
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        logger.error("visitFileFailed", file);
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        /* don't put trace here because it will be called on each dir but won't do anything */
        return FileVisitResult.CONTINUE;
    }

    private void extractAndInsert(Path path){
        logger.trace("extractAndInsert: ", path);
        FileModel fileModel = FileModels.extractInfo(path);
        DatabaseInsertCommand insert = new DatabaseInsertCommand(fileModel);
        dbManager.execute(insert);
    }
}
