import java.sql.*;

public class MySqlConnector {

    public static final String DB_NAME = "acme";
    public static final String DB_HOST = "jdbc:mysql://localhost:3306/";
    public static final String USER_NAME = "qp";
    public static final String PASSWORD = "12345";

    public static final String DB_URL = DB_HOST + DB_NAME;

    public static void main(String[] args){

        try(Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)) {
            try(Statement statement = connection.createStatement()){

                String sql = "select * from users";

                try(ResultSet result = statement.executeQuery(sql)){
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
}
