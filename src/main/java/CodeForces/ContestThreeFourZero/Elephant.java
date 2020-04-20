package main.java.CodeForces.ContestThreeFourZero;

import java.util.Scanner;

public class Elephant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int currentStep = 5;
        int totalSteps = 0;
        while(input != 0) {
            totalSteps += input / currentStep;
            input %= currentStep;
            currentStep--;
        }
        System.out.println(totalSteps);
    }
}
