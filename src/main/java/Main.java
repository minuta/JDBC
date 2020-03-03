public class Main {

    public static void main(String[] args) {

        final String DB_NAME = "acme";
        final String DB_HOST = "jdbc:mysql://localhost:3306/";
        final String USER_NAME = "qp";
        final String PASSWORD = "12345";


        MySqlConnector mySqlConnector = new MySqlConnector(DB_HOST, DB_NAME, USER_NAME, PASSWORD);

        String sqlCommand = "select * from users";

        mySqlConnector.runQuery(sqlCommand);

    }
}
