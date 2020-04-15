package main.java.leetcode.Array.EmployeeImportance;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Integer> importanceMap = new HashMap<>();
        HashMap<Integer, List<Integer>> subordinatesMap = new HashMap<>();
        int totalImportance = 0;
        for(int i = 0; i < employees.size(); i++) {
            int employeeID = employees.get(i).id;
            int employeeImportance = employees.get(i).importance;
            List<Integer> subordinates = employees.get(i).subordinates;
            importanceMap.put(employeeID, employeeImportance);
            subordinatesMap.put(employeeID, subordinates);
        }

        Queue<Integer> subordinatesQueue = new ArrayDeque<>();
        subordinatesQueue.add(id);
        while(!subordinatesQueue.isEmpty()) {
            int currentEmployee = subordinatesQueue.poll();
            totalImportance += importanceMap.get(currentEmployee);
            if(subordinatesMap.get(currentEmployee) != null) {
                List<Integer> subordinatesList = subordinatesMap.get(currentEmployee);
                for(int i = 0; i < subordinatesList.size(); i++) {
                    subordinatesQueue.add(subordinatesList.get(i));
                }
            }
        }
        return totalImportance;
    }

    public static void main(String[] args) {

    }
}
