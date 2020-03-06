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

    public void runQuery (String sqlCommand){
            try(Statement statement = connection.createStatement()){
                try(ResultSet result = statement.executeQuery(sqlCommand)){
                    while(result.next()) {
                        int id = result.getInt(1);
                        String firstName = result.getString("first_name");
                        String lastName  = result.getString("last_name");
                        System.out.println(id + " " + firstName + " " + lastName);
                    }
                }
            } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Connection initConnection() throws SQLException {
        return DriverManager.getConnection(dbHost + dbName, userName, userPass);
    }
}
