package main.java.CodeForces.ContestThreeSixNine;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://codeforces.com/problemset/problem/711/A
 */
public class Udayland {
    // n row of seats
    // 4 seats in each row
    // n lines follow 5 chars the first two denote the first pair of seats
    // | equals to the walkway
    // 'O' is an empty seat and 'X' denotes an occupied seat
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();  // nextInt method does not read the newline character
        ArrayList<String> bus = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            bus.add(sc.nextLine());
        }
        boolean found = false;
        for(int i = 0; i < bus.size(); i++) {
            StringBuilder busRow = new StringBuilder(bus.get(i));
            if(busRow.charAt(0) == 'O' && busRow.charAt(1) == 'O') {
                busRow.setCharAt(0, '+');
                busRow.setCharAt(1, '+');
                found = true;
            } else if(busRow.charAt(3) == 'O' && busRow.charAt(4) == 'O') {
                busRow.setCharAt(3, '+');
                busRow.setCharAt(4, '+');
                found = true;
            }
            if(found) {
                bus.set(i, busRow.toString());
                break;
            }
        }
        if(found) {
            System.out.println("YES");
            for(String s: bus) {
                System.out.println(s);
            }
        } else {
            System.out.println("NO");
        }
    }
}
