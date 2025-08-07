package com.dsa.questions.potd;
//Day = 06/08/25

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Integer capacity;
    private final Map<Integer, Node> cache;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        Node node = cache.get(key);
        moveToTop(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            moveToTop(node);
        }
        else{
            if(cache.size() == capacity){
                Node node = tail.prev;
                removeNode(node);
                cache.remove(node.key);
            }
            Node newNode = new Node(key,value);
            cache.put(key,newNode);
            addToTop(newNode);
        }
    }

    public void moveToTop(Node node){
        removeNode(node);
        addToTop(node);
    }

    public void removeNode(Node node){
         node.prev.next = node.next;
         node.next.prev = node.prev;
    }

    public void addToTop(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

}
