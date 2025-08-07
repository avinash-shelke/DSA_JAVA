package com.dsa.questions.potd;
// Day = 07/08/2025

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;

public class TimestampBasedKVStore {

    private final Map<String, TreeMap<Integer, String>> mp;

    public TimestampBasedKVStore() {
        mp = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        mp.putIfAbsent(key, new TreeMap<>());
        mp.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!mp.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> timeMap = mp.get(key);
        Integer floorKey = timeMap.floorKey(timestamp);
        if (floorKey == null) {
            return "";
        }
        return timeMap.get(floorKey);
    }
}
