package tdd;

import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInitializer {
    public DBInitializer() {
        dbConnectionManager = DBConnectionManager.getInstance();
    }

    Connection connection;
    DBConnectionManager dbConnectionManager;
    Statement statement;
    String query;
    String[] querys = null;
    String dbProperty = "";

    public void close() {
        dbConnectionManager.freeConnection(dbProperty, connection);
    }

    public void executeQuerys(String[] querys)
        throws SQLException {
        statement = connection.createStatement();
        for(int i = 0; i < querys.length; ++i) {
            query = querys[i];
            if (querys[i] != null) statement.executeQuery(query);
        }

        statement.close();
    }

    public void executeScript(String filepath) throws SQLException {
        try {
            querys = Text.getTextSplit(";", filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        executeQuerys(querys);
    }

    public void initDataSet(String aSettingGroup) {
        try {
            String directory = "./dbScript/" + aSettingGroup + "/";
            executeScript(directory + "db_dropQurey.txt");
            executeScript(directory + "db_createQuery.txt");
            executeScript(directory + "db_insertQuery.txt");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initDBProperty(String aDBProperty) {
        dbProperty = aDBProperty;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
