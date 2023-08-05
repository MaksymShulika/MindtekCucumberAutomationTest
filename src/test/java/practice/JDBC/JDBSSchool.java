package practice.JDBC;

import utillities.JDBSUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBSSchool {
    public static void main(String[] args) throws SQLException {

        JDBSUtils.establishConnection();
        List<Map<String, Object>> resultSet1 = JDBSUtils.runQuery("select * from subjects");
        List<Map<String, Object>> resultSet2 = JDBSUtils.runQuery("select * from week");
        List<Map<String, Object>> resultSet3 = JDBSUtils.runQuery("select * from teachers");

        StringBuilder full = new StringBuilder();
        for (Map<String, Object> data1 : resultSet1) {
            for (Map<String, Object> data2 : resultSet2) {
                if (data1.get("day_id").equals(data2.get("day_id"))) {
                    full.append(data2.get("day_of_the_week")).append(" we have ");
                    for (Map<String, Object> data3 : resultSet3) {
                        if (data1.get("teacher_id").equals(data3.get("teacher_id"))) {
                            full.append(data1.get("subject_name")).append(" with ").append(data3.get("teacher_name"));
                            System.out.println(full);
                            full = new StringBuilder();
                        }
                    }
                }
            }
        }

        JDBSUtils.closeDataBase();


    }
}
