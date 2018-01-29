package mainentry;

import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.sql.*;

import static mainentry.MySqlDatabaseConstants.*;

/**
 * @author Seeker
 * @date 2018/1.28
 */
public class DatabaseUtility {
    private static DatabaseUtility databaseUtility;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    public static DatabaseUtility getDatabaseUtility() {
        if(databaseUtility==null) {
            databaseUtility= new DatabaseUtility();
        }
        return databaseUtility;
    }

    private DatabaseUtility() {
        connectToDatabase();
    }

    private void connectToDatabase() {
        BASE64Decoder base64Decoder=new BASE64Decoder();
        String password=null;
        try {
            password = new String(base64Decoder.decodeBuffer(PASSWORD_ENCODED));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            if(connection==null || connection.isClosed()){
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL,
                        USER,
                        password);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet doQuery (String sql) throws SQLException {
        ResultSet queryResultSet=null;
        if(connection== null || connection.isClosed()) {
            connectToDatabase();
        }
        try {
            statement=connection.createStatement();
            queryResultSet=statement.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return queryResultSet;
    }

    public int doUpdate (String sql) throws SQLException {
        int result=-1;
        if(connection==null || connection.isClosed()) {
            connectToDatabase();
        }
        try {
            statement=connection.createStatement();
            result=statement.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public void close(){
        try {
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
