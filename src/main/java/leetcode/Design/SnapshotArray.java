package main.java.leetcode.Design;

import java.util.HashMap;
import java.util.LinkedList;

public class SnapshotArray {
  private HashMap<Integer, HashMap<Integer, Integer>> map;
  private LinkedList<LinkedList<Integer>> list;
  private int length;
  private int snapId;

  public SnapshotArray(int length) {
    this.length = length;
    map = new HashMap<>();
    snapId = 0;
  }

  public void set(int index, int val) {
    HashMap<Integer, Integer> subMap = map.get(snapId);
    subMap.put(index, val);
  }

  public int snap() {
      HashMap<Integer, Integer> copy = new HashMap<>(map.get(snapId));
    this.snapId++;
    map.put(snapId, copy);
    return snapId - 1;
  }

  public int get(int index, int snap_id) {
    if (snap_id > this.snapId) return -1;
    if (!map.get(snap_id).containsKey(index)) return 0;
    return map.get(snap_id).get(index);
  }

  public static void main(String[] args) {
    SnapshotArray s = new SnapshotArray(3);
    s.set(0, 5);
    System.out.println(s.snap());
    s.set(0, 6);
    s.get(0, 0);
  }
}
