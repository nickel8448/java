package main.java.CodeForces.ContestSixTwoNine;

import java.util.Scanner;

public class DivisibilityProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTests = sc.nextInt();
        while(numTests != 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a%b == 0) System.out.println(0);
            else {
                int remainder = a % b;
                int numMoves = b - remainder;
                System.out.println(numMoves);
            }
            numTests--;
        }
    }
}
