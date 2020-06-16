package main.java.leetcode.Design;

import java.util.HashMap;
import java.util.TreeMap;

public class TimeMap {
  private HashMap<String, TreeMap<Integer, String>> map;
  /** Initialize your data structure here. */
  public TimeMap() {
    map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    TreeMap<Integer, String> timestampMap;
    if (map.containsKey(key)) {
      timestampMap = map.get(key);
    } else {
      timestampMap = new TreeMap<>();
    }
    timestampMap.put(timestamp, value);
    map.put(key, timestampMap);
  }

  public String get(String key, int timestamp) {
    String result = "";
    if (map.containsKey(key)) {
      TreeMap<Integer, String> timestampMap = map.get(key);
      Integer fKey = timestampMap.floorKey(timestamp);
      if (fKey != null) {
        result = timestampMap.get(fKey);
      }
    }
    return result;
  }
}
