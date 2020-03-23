package main.java.LeetCode.Design;

import java.util.ArrayDeque;
import java.util.Queue;

public class MovingAverage {

    ArrayDeque<Integer> elements;
    int size;
    double currentAvg;
    int currentSum;

    public MovingAverage(int size) {
        elements = new ArrayDeque<>();
        this.size = size;
        currentAvg = 0;
    }

    public double next(int val) {
        if(elements.size() == size) {
            currentSum -= elements.removeFirst();
        }
        elements.add(val);
        currentSum += val;
        currentAvg = (double) currentSum / (double) elements.size();
        return currentAvg;
    }

    public static void main(String []args) {
        MovingAverage m = new MovingAverage(5);
        System.out.println(m.next(12009));
        System.out.println(m.next(1965));
        System.out.println(m.next(-940));
        System.out.println(m.next(-8516));
        System.out.println(m.next(-16446));
        System.out.println(m.next(7870));
        System.out.println(m.next(25545));
        System.out.println(m.next(-21028));
        System.out.println(m.next(18430));
        System.out.println(m.next(-23464));

    }
}
