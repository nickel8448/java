package main.java.CodeForces.ContestThreeEightEight;

import java.util.Scanner;

public class BachgoldProblem {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(n / 2);
    if (n % 2 == 0) {
      for (int i = 1; i <= n / 2 - 1; i++) {
        System.out.print("2 ");
      }
      System.out.println("2");
    } else {
      for (int i = 1; i <= n / 2 - 1; i++) {
        System.out.print("2 ");
      }
      System.out.println("3");
    }
    sc.close();
  }
}
