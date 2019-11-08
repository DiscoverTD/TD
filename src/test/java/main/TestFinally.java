package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @ Author     ：liye
 * @ Date       ：Created in 23:50 2019/9/2
 * @ Description：
 * @ Modified By：liye
 * @Version: V
 */
public class TestFinally {
    public static void main(String[] args) {
       List<String> list = new ArrayList<>();
       list.add("1");
       list.add("2");
       list.add("3");
        for (String s : list) {
            if ("2".equals(s)){
                list.remove(s);
            }
        }
        System.out.println(list);
    }
    public static int getInt(int i){
        try {
            return 5/i;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 3;
    }
}
