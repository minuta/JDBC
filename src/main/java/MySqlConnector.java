import java.sql.*;

public class MySqlConnector {

    private String dbName;
    private String dbHost;
    private String userName;
    private String userPass;

    public MySqlConnector(String dbHost, String dbName, String userName, String userPass) {
        this.dbName = dbName;
        this.dbHost = dbHost;
        this.userName = userName;
        this.userPass = userPass;
    }

    public void runQuery (String sqlCommand){

        try(Connection connection = DriverManager.getConnection(dbHost + dbName, userName, userPass)) {
            try(Statement statement = connection.createStatement()){
                try(ResultSet result = statement.executeQuery(sqlCommand)){
                    while(result.next()) {
                        int id = result.getInt(1);
                        String firstName = result.getString("first_name");
                        String lastName  = result.getString("last_name");
                        System.out.println(id + " " + firstName + " " + lastName);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getDbName() {
        return dbName;
    }

    public String getDbHost() {
        return dbHost;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public void setDbHost(String dbHost) {
        this.dbHost = dbHost;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
