package com.dsa.basic;

import java.util.*;

public class Set {
    public static void main(String [] args){

        String[] vo = {"a", "e", "i", "o", "u"};
        HashSet<String> st = new HashSet<>(Arrays.asList(vo));
        System.out.println(st);

    }
}
