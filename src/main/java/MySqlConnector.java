import java.sql.*;

public class MySqlConnector {

    private final String dbName;
    private final String dbHost;
    private final String userName;
    private final String userPass;
    private Connection connection;

    public MySqlConnector(String dbHost, String dbName, String userName, String userPass) {
        this.dbName = dbName;
        this.dbHost = dbHost;
        this.userName = userName;
        this.userPass = userPass;
        try {
            this.connection = initConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ResultSet runQuery(String sqlCommand) {
        ResultSet result = null;
        try{
            Statement statement = connection.createStatement();
            result = statement.executeQuery(sqlCommand);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    private Connection initConnection() throws SQLException {
        return DriverManager.getConnection(dbHost + dbName, userName, userPass);
    }
}
