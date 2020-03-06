import java.sql.ResultSet;
import java.sql.SQLException;



public class Main {

    public static void displayUserNames(ResultSet resultSet) throws SQLException {
        while(resultSet.next()) {
            int id = resultSet.getInt(1);
            String firstName = resultSet.getString("first_name");
            String lastName  = resultSet.getString("last_name");
            System.out.println(id + " " + firstName + " " + lastName);
        }
    }

    public static void main(String[] args) throws SQLException {

        final String DB_NAME = "acme";
        final String DB_HOST = "jdbc:mysql://localhost:3306/";
        final String USER_NAME = "qp";
        final String PASSWORD = "12345";


        System.out.println("Connecting to MySQL database...");
        MySqlConnector mySqlConnector = new MySqlConnector(DB_HOST, DB_NAME, USER_NAME, PASSWORD);

        System.out.println("Executing SQL statement...");
        String sqlCommand = "select id, first_name, last_name from users";
        ResultSet resultSet = mySqlConnector.runQuery(sqlCommand);
        displayUserNames(resultSet);


    }
}
