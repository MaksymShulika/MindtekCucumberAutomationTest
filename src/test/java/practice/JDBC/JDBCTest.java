package practice.JDBC;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {


        /**
         * We need 3 things to connect to DataBase :
         *
         * 1. Connection Object (java.sql)
         * 2. Statement Object (java.sql)
         * 3. ResultSet Object
         *
         */

        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5434/postgres",
                "postgres",
                "Admin123");

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); //configurations

        ResultSet resultSet = statement.executeQuery("select * from employees");//from employees

//        ResultSet.TYPE_SCROLL_INSENSITIVE: This type of result set allows scrolling in both forward and backward directions.
//                However, it is insensitive to changes made to the database by other transactions during the lifetime of the result set.
//                In other words, it will not reflect any changes made by other users after the result set is created.

//        ResultSet.CONCUR_READ_ONLY: This is the default concurrency mode.
//                It creates a read-only result set, meaning you cannot update the rows in the result set
//                and any attempt to modify the data will result in an SQLException.
//                This mode is suitable for scenarios where you only need to retrieve and display data from the database. (edited)

        resultSet.next();//one line(row) down

        System.out.println(resultSet.getString(1));//getString(columIndex)

        resultSet.next();
        System.out.println(resultSet.getString(1));

        //Steven King

        int count = 0;

        try {
            while (resultSet.next()) {
                count++;
                if (resultSet.getString("employee_id").equals("100")) {
                    System.out.println(count + ". " + resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
                }

            }
        }catch ( Exception e){
            System.out.println("Error in wile |38| line");
        }


        /**
         *
         * ResultSetMetaData --> It holds a data about data (Data about table);
         *
         */

        ResultSetMetaData metaData = resultSet.getMetaData();

        System.out.println(metaData.getColumnCount());//count of colum
        System.out.println("Table name: " + metaData.getTableName(1));
        System.out.println("Here (.getSchemaName(1) : )" + metaData.getSchemaName(1));

        System.out.println("--------------------------------------------------------");

        for (int i = 1; i < metaData.getColumnCount(); i++){
            System.out.println("Table: " + metaData.getTableName(i) + ". Colum cumber: " + i +
                    ". Colum name: " + metaData.getColumnName(i));
        }




    }
}
