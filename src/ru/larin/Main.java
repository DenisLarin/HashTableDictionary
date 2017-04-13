package ru.larin;

import java.util.Scanner;

/**
 * Created by denis__larin on 13.04.17.
 */
public class Main {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("Denis","1");
        map.put("Anton","2");
        map.put("denis","3");
        System.out.println(map.get("Denis"));
        System.out.println(map.get("denis"));
    }
}
