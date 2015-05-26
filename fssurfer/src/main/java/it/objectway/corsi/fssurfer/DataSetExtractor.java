package it.objectway.corsi.fssurfer;

import it.objectway.corsi.fssurfer.impl.DataBaseManagerImpl;
import it.objectway.corsi.fssurfer.impl.FileManagerImpl;
import it.objectway.corsi.fssurfer.interfaces.DataBaseManager;
import it.objectway.corsi.fssurfer.interfaces.FileManager;
import it.objectway.corsi.fssurfer.utils.DataBases;

/**
 * Created by stageusr2015 on 26/05/2015.
 */
public class DataSetExtractor {
    private static DataBaseManager dataBaseManager = new DataBaseManagerImpl();
    private static FileManager fileManager = new FileManagerImpl();

    public static void main(String[] args) {
        String outXml = "C:\\Users\\stageusr2015\\Desktop\\stage\\esercizi\\files\\fssurfer\\db\\dataset.xml";
        DataBases.extractDataSet(dataBaseManager.getConnection(),
                "files", "SELECT * FROM FILES WHERE LENGTH(abspath) < 10 LIMIT 10",
                fileManager.getOutputStream(outXml));
    }
}
