package com.dsa.basic.utils;

public class MyArray<T> {
  private Object[] arr;
  private int size;
  private static final int DEFAULT_CAPACITY = 5;

  public MyArray(){
    this.arr = new Object[DEFAULT_CAPACITY];
    this.size = 0;
  }

  public void add(T element){
    arr[size++] = element;
  }

  public T get(int index){
    return (T) arr[index];
  }
}
