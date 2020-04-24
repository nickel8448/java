package main.java.dynamic_programming;

import java.util.Arrays;

public class FibTopDown {

    final int MAX = 100;
    final int NIL = -1;

    int[] lookup;

    FibTopDown() {
    	lookup = new int[MAX];
    	Arrays.fill(lookup, NIL);
    }
    
    public int fib(int n) {
    	if(lookup[n] == NIL) {
    		if(n <= 1)
    			lookup[n] = n;
    		else
    			lookup[n] = fib(n-1) + fib(n-2);
    	}
    	return lookup[n];
    }

    public static void main(String[] args) {
    	FibTopDown f = new FibTopDown();
    	System.out.println(f.fib(40));
    }
}
