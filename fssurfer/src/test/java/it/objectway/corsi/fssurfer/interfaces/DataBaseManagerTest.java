package it.objectway.corsi.fssurfer.interfaces;

import it.objectway.corsi.fssurfer.enums.FileType;
import it.objectway.corsi.fssurfer.impl.DataBaseManagerImpl;
import it.objectway.corsi.fssurfer.impl.LogManagerImpl;
import it.objectway.corsi.fssurfer.models.FileModel;
import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.SortedTable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.hsqldb.HsqldbDataTypeFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

import static org.easymock.EasyMock.*;

/**
 * Created by stageusr2015 on 25/05/2015.
 */
public class DataBaseManagerTest extends DBTestCase {
    private static final String DATAPATH = "C:\\Users\\stageusr2015\\Desktop\\stage\\esercizi\\files\\fssurfer\\db\\dataset.xml";
    private static final String DATATEST = "C:\\Users\\stageusr2015\\Desktop\\stage\\esercizi\\files\\fssurfer\\db\\testdataset.xml";
    private static LogManager logger = new LogManagerImpl(DataBaseManagerTest.class);

    private static Connection connection;
    public DataBaseManagerTest(String name) throws SQLException {
        super(name);
        logger.debug("created db");
        System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS,
                "org.hsqldb.jdbcDriver"
        );
        System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL,
                "jdbc:hsqldb:mem:sample"
        );
        System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME,
                "sa"
        );
        System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD,
                ""
        );
        /*System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA,
                "sample"
        );*/
        createTable();
        logger.trace("Constructor: exit");
    }

    private void createTable() {
        try {
            Connection jdbcConnection = getJdbcConnection();
            jdbcConnection.createStatement().executeUpdate(
                    "CREATE TABLE files ( " +
                            "  abspath VARCHAR(500) NOT NULL , " +
                            "  name VARCHAR(100), " +
                            "  type VARCHAR(4), " +
                            "  extension VARCHAR(45), " +
                            "  permissions VARCHAR(3), " +
                            "  size BIGINT, " +
                            "  PRIMARY KEY (abspath) )");
        } catch (SQLException e) {
            logger.warn("table already exists", e.getMessage());
        }
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().setColumnSensing(true).build(new FileInputStream(DATAPATH));
    }

    public void testInsertFile() throws Exception {
        logger.trace("testInsertFile: start");
        FileModel test = new FileModel(
                "testme.xml", FileType.FILE, ".test",
                "rwx", 10, "C:\\test.xml"
        );

        DataBaseManager mock = createMockBuilder(DataBaseManagerImpl.class)
                .addMockedMethod("getConnection").createMock();
        expect(mock.getConnection()).andReturn(getJdbcConnection());
        replay(mock);
        mock.insertFile(test);
        verify(mock);

        // Fetch database data after executing your code
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = new SortedTable(databaseDataSet.getTable("files"));

        IDataSet expected = null;
        try {
            expected = new FlatXmlDataSetBuilder().build(new FileInputStream(DATATEST));

            // Load expected data from an XML dataset
            ITable expectedTable = new SortedTable(expected.getTable("files"));
            // Assert actual database table match expected table
            Assertion.assertEquals(expectedTable, actualTable);
        } catch (DataSetException e) {
            e.printStackTrace();
            fail(e.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    public void testInsertFileNoMock() throws Exception {
        logger.trace("testInsertFile: start");
        FileModel test = new FileModel(
                "testme.xml", FileType.FILE, ".test",
                "rwx", 10, "C:\\test.xml"
        );

        DataBaseManager dataBaseManager = new DataBaseManagerImpl();
        dataBaseManager.setConnection(getJdbcConnection());

        dataBaseManager.insertFile(test);
        // Fetch database data after executing your code
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = new SortedTable(databaseDataSet.getTable("files"));

        IDataSet expected = null;
        try {
            expected = new FlatXmlDataSetBuilder().build(new FileInputStream(DATATEST));

            // Load expected data from an XML dataset
            ITable expectedTable = new SortedTable(expected.getTable("files"));
            // Assert actual database table match expected table
            Assertion.assertEquals(expectedTable, actualTable);
        } catch (DataSetException e) {
            e.printStackTrace();
            fail(e.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    private Connection getJdbcConnection() {
        try {
            if(connection == null) {
                connection = super.getConnection().getConnection();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    protected void setUpDatabaseConfig(DatabaseConfig config) {
        config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new HsqldbDataTypeFactory());
    }
}
