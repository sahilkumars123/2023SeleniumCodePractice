package org.SeleniumCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Tekion {

    public static void main(String[] args) {

        String s = "sahilkumar";
        HashMap<Character,Integer> map = new HashMap<>();

        char[] array = s.toCharArray();

        for(char ch: array){

             Integer i = map.get(ch);
             if(i==null){
                map.put(ch,1);
             }
             else {
                 map.put(ch,++i);
             }
        }
        System.out.println(map);

        Set<Map.Entry<Character, Integer>> enteries = map.entrySet();

        for(Map.Entry<Character, Integer> entry : enteries)
        {
            if(entry.getValue() >= 1){
                System.out.println(entry.getKey());
            }
        }

    }
}
