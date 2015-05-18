package it.objectway.corsi.fssurfer.interfaces;

import it.objectway.corsi.fssurfer.models.FileModel;

/**
 * Created by stageusr2015 on 18/05/2015.
 */
public interface DataBaseManager {
    int insertFile(FileModel fileModel);

    void execute(Runnable command);

    void clean();
}
