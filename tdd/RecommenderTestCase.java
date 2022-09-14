package tdd;

import java.sql.Connection;

public class RecommenderTestCase extends TestCase{
    DBInitializer dbInitializer;
    Connection connection;
    DBConnectionManager dbConnectionManager;

    public RecommenderTestCase(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        dbConnectionManager = DBConnectionManager.getInstance();
        connection = dbConnectionManager.getConnection("testPrj");
        dbInitializer = new DBInitializer();
        dbInitializer.initDBProperty('testPrj');
        dbInitializer.setCon(connection);
    }

    protected void tearDown() throws Exception {
        dbConnectionManager.freeConnection("testPrj", connection);
    }
}
