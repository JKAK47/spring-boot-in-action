package org.vincent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by PengRong on 2018/9/19.
 */
public class App {
    public  static  void  main(String[] args){
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        /**
         * 以前一般做法
         */
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }
        System.out.println("----------------------");
        items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
        System.out.println("----------------------");
        items.forEach((k,v)->{
            System.out.println("Item : " + k + " Count : " + v);
            if("E".equals(k)){
                System.out.println("Hello E");
            }
        });


        List<String> itemsList = new ArrayList<>();
        itemsList.add("A");
        itemsList.add("B");
        itemsList.add("C");
        itemsList.add("D");
        itemsList.add("E");

        for(String item : itemsList){
            System.out.println(item);
        }
    }
}
