package assigments;

import java.sql.*;

public class test123 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://3.137.169.132:5432/elardb",
                "impleyer",
                "ciforest");

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); //configurations

        ResultSet resultSet = statement.executeQuery("select * from core_company");

        while (resultSet.next()){
            System.out.println(resultSet.getString("id"));
        }
    }
}
