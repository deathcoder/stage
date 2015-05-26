package it.objectway.corsi.fssurfer.interfaces;

import it.objectway.corsi.fssurfer.models.FileModel;

import java.sql.Connection;

/**
 * Created by stageusr2015 on 18/05/2015.
 */
public interface DataBaseManager {
    boolean insertFile(FileModel fileModel);

    void execute(Runnable command);

    void clean();

    int getCount();

    boolean updateFile(FileModel file);

    FileModel deleteFile(String absPath);

    Connection getConnection();

    void setConnection(Connection jdbcConnection);
}
