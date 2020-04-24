package main.java.leetcode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FindRestaurants {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        if(list1.length > list2.length)
            findRestaurant(list2, list1);
        HashMap<String, Integer> listOneMap = new HashMap<>();
        for(int i = 0; i < list1.length; i++) {
            listOneMap.put(list1[i], i);
        }
        HashMap<Integer, ArrayList<String>> diffMap = new HashMap<>();
        for(int i = 0; i < list2.length; i++) {
            if(listOneMap.containsKey(list2[i])) {
                int sum = i + listOneMap.get(list2[i]);
                if(diffMap.containsKey(sum)) {
                    diffMap.get(sum).add(list2[i]);
                } else {
                    ArrayList<String> stringList = new ArrayList<>();
                    stringList.add(list2[i]);
                    diffMap.put(sum, stringList);
                }
            }
        }
        int minimum = Integer.MAX_VALUE;
        ArrayList<String> result = new ArrayList<>();
        for(int diff : diffMap.keySet()) {
            if(minimum > diff) {
                result = diffMap.get(diff);
                minimum = diff;
            }
        }
        String[] resultArray = new String[result.size()];
        for(int i = 0; i < resultArray.length; i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        System.out.println(Arrays.toString(findRestaurant(list1, list2)));
    }
}
