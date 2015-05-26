package it.objectway.corsi.fssurfer.utils;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.AmbiguousTableNameException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by stageusr2015 on 25/05/2015.
 */

public class DataBases {

    public static IDataSet extractDataSet(Connection jdbcConnection, String table, String select, OutputStream fos) {

        // database connection

        IDatabaseConnection connection = getDatabaseConnection(jdbcConnection);


        // partial database export

        QueryDataSet partialDataSet = new QueryDataSet(connection);

        dataSetAddTable(table, select, partialDataSet);

        flatXmlWrite(fos, partialDataSet);
        return partialDataSet;
    }

    public  static IDataSet extractDataSet(Connection jdbcConnection, OutputStream fos) {
        // database connection

        IDatabaseConnection connection = getDatabaseConnection(jdbcConnection);

        // full database export

        IDataSet fullDataSet = getFullDataSet(connection);

        flatXmlWrite(fos, fullDataSet);
        return fullDataSet;
    }

    private static IDataSet getFullDataSet(IDatabaseConnection connection){
        try {
            return connection.createDataSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void flatXmlWrite(OutputStream fos, QueryDataSet partialDataSet) {
        try {
            FlatXmlDataSet.write(partialDataSet,
                    fos);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DataSetException e) {
            e.printStackTrace();
        }
    }

    private static void flatXmlWrite(OutputStream fos, IDataSet dataSet) {
        try {
            FlatXmlDataSet.write(dataSet,
                    fos);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DataSetException e) {
            e.printStackTrace();
        }
    }

    private static void dataSetAddTable(String table, String select, QueryDataSet partialDataSet) {
        try {
            partialDataSet.addTable(table, select);
        } catch (AmbiguousTableNameException e) {
            e.printStackTrace();
        }
    }

    private static IDatabaseConnection getDatabaseConnection(Connection jdbcConnection) {
        try {
            return new DatabaseConnection(jdbcConnection);
        } catch (DatabaseUnitException e) {
            e.printStackTrace();
        }
        return null;
    }

}
