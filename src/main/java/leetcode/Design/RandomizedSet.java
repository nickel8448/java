package main.java.leetcode.Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet {

  private HashMap<Integer, Integer> indexMap;
  private List<Integer> list;
  private Random randomNumberGenerator;

  /** Initialize your data structure here. */
  public RandomizedSet() {
    indexMap = new HashMap<>();
    list = new ArrayList<>();
    randomNumberGenerator = new Random();
  }

  /**
   * Inserts a value to the set. Returns true if the set did not already contain the specified
   * element.
   */
  public boolean insert(int val) {
    if (!indexMap.containsKey(val)) {
      indexMap.put(val, list.size());
      list.add(list.size(), val);
      return true;
    }
    return false;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if (indexMap.containsKey(val)) {
      int elementIndex = indexMap.get(val);
      int lastElement = list.get(list.size() - 1);
      list.set(elementIndex, lastElement);
      list.remove(list.size() - 1);
      indexMap.put(lastElement, elementIndex);
      indexMap.remove(val);
      return true;
    }
    return false;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    int randomIndex = randomNumberGenerator.nextInt(list.size());
    return list.get(randomIndex);
  }

  public static void main(String[] args) {
    RandomizedSet s = new RandomizedSet();
    System.out.println(s.insert(1));
    System.out.println(s.remove(2));
    System.out.println(s.insert(2));
    System.out.println(s.getRandom());
    System.out.println(s.remove(1));
    System.out.println(s.insert(2));
    System.out.println(s.getRandom());
  }
}
