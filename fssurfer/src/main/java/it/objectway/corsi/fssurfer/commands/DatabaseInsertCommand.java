package it.objectway.corsi.fssurfer.commands;

import it.objectway.corsi.fssurfer.impl.DataBaseManagerImpl;
import it.objectway.corsi.fssurfer.impl.LogManagerImpl;
import it.objectway.corsi.fssurfer.interfaces.DataBaseManager;
import it.objectway.corsi.fssurfer.interfaces.LogManager;
import it.objectway.corsi.fssurfer.models.FileModel;

/**
 * Created by stageusr2015 on 18/05/2015.
 */
public class DatabaseInsertCommand implements Runnable {
    private FileModel fileModel;
    private static DataBaseManager dbManager = new DataBaseManagerImpl();
    private static LogManager logger = new LogManagerImpl(DatabaseInsertCommand.class);

    public DatabaseInsertCommand(FileModel fileModel) {
        this.fileModel = fileModel;
    }

    public void run() {
        logger.trace("run: ", fileModel.getName());
        dbManager.insertFile(fileModel);
    }
}
