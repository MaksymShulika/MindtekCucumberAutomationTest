package practice.JDBC;

import utillities.JDBSUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBCTest3 {
    public static void main(String[] args) throws SQLException {

        JDBSUtils.establishConnection();
        List<Map<String, Object>> tableData = JDBSUtils.runQuery("select * from jobs order by job_id desc");
        JDBSUtils.closeDataBase();

        for (Map<String, Object> data : tableData){
            System.out.println(data.get("job_id"));
        }


        /**
         * Error here:
         * Exception in thread "main" org.postgresql.util.PSQLException: This statement has been closed.
         */

//        List<Map<String, Object>> tableData2 = JDBSUtils.runQuery("select * from jobs order by job_id desc");
//
//        for (Map<String, Object> data : tableData2){
//            System.out.println(data.get("job_id"));
//        }

    }
}
