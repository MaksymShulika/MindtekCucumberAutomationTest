package practice.JDBC;

import io.cucumber.java.it.Ma;

import java.sql.*;
import java.util.*;

public class JDBCTest2 {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5434/postgres",
                "postgres",
                "Admin123");
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from jobs");

        resultSet.next();

        //System.out.println(resultSet.getString("first_name"));

        List<Map<String, Object>> tableData = new ArrayList<>();

        ResultSetMetaData metaData = resultSet.getMetaData();

        while (resultSet.next()) {

            Map<String, Object> rowData = new HashMap<>();

            for (int columIndex = 1; columIndex <= metaData.getColumnCount(); columIndex++) {
                rowData.put(metaData.getColumnName(columIndex), resultSet.getString(metaData.getColumnName(columIndex)));
            }
            tableData.add(rowData);
        }

        for (Map columData : tableData) {
            if (columData.get("job_title").toString().contains("Manager"))
                System.out.println("Max for " + columData.get("job_title") + " is " + columData.get("max_salary"));
        }

        System.out.println("==========================");

        for (Map columData : tableData) {
            if (columData.get("job_title").toString().contains("Manager"))
                System.out.println("Min for " + columData.get("job_title") + " is " + columData.get("min_salary"));
        }

        System.out.println("===============================");

        String result = "";

        for (Map columData : tableData) {
            if (columData.get("job_title").toString().equals("Sales Manager")) {
                result = "Min and Max for Sales Manager is: " + columData.get("min_salary") + " and " + columData.get("max_salary");
            }
        }

        System.out.println(result);
        /**
         *
         * Get min and max salary for sales manager :
         *
         * output ---> Min and Max for Sales Manager is
         */


        System.out.println("\n"+getMinAndMaxSalaryFroJob("select * from jobs", "Sales Manager"));


    }


    public static String getMinAndMaxSalaryFroJob(String query, String jobTitle) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5434/postgres",
                "postgres",
                "Admin123");
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(query);

        List<Map<String, Object>> tableData = new ArrayList<>();

        ResultSetMetaData metaData = resultSet.getMetaData();

        while (resultSet.next()) {

            Map<String, Object> rowData = new HashMap<>();

            for (int columIndex = 1; columIndex <= metaData.getColumnCount(); columIndex++) {
                rowData.put(metaData.getColumnName(columIndex), resultSet.getString(metaData.getColumnName(columIndex)));
            }
            tableData.add(rowData);
        }

        String result = "";

        for (Map columData : tableData) {
            if (columData.get("job_title").toString().equals(jobTitle)) {
                result = "Min and Max for " + jobTitle + " is: " + columData.get("min_salary") + " and " + columData.get("max_salary");
                break;
            }
        }
        return result;
    }
}
