package main.java.CodeForces.BetaRoundSixFive;

import java.util.Scanner;

/**
 * Problem: https://codeforces.com/problemset/problem/71/A
 */
public class TooLongWords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < n; i++) {
            String sb = sc.nextLine();
            if(sb.length() > 10) {
                sb = sb.charAt(0) + Integer.toString(sb.length() - 2) + sb.charAt(sb.length() - 1);
            }
            System.out.println(sb);
        }
    }
}
