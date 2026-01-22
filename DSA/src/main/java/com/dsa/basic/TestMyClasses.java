package com.dsa.basic;

import com.dsa.basic.utils.MyArray;

public class TestMyClasses {
  public static void main(String[] args){
    MyArray<String> arr = new MyArray<String>();
    arr.add("34");
    arr.add("45");
    arr.add("56");
    arr.add("67");
    arr.add("89");

    System.out.println(arr);
    String a = arr.get(4);
    System.out.println(a);
  }
}
