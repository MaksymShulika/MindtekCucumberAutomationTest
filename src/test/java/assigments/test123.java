package assigments;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class test123 {
    public static void main(String[] args) throws SQLException {
        Random randNum = new Random();


        System.out.println(randNum.nextInt(900) + 100000);

        Map<String, Integer> map = new HashMap<>();

        String str = "3334333872983174912834712531902382174982174980173872984ncbkjasdbsakjblkjsdbvaskjnkjnsdkjasfnd182730197dkjanfdkjsnd";

        for (Character s : str.toCharArray()){
            if (!map.containsKey(s.toString())) map.put(s.toString(), 1);
            else map.put(s.toString(), map.get(s.toString()) + 1);
        }


        System.out.println(map);
    }
}
