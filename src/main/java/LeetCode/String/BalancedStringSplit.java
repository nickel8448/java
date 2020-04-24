package main.java.leetcode.String;

public class BalancedStringSplit {
    public static int balancedStringSplit(String s) {
        int balance = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'R')
                balance++;
            else if(s.charAt(i) == 'L')
                balance--;
            if(balance == 0) count++;
        }
        return count;
    }

    public static void main(String []args) {
        String s = "LLLLRRRR";
        System.out.println(balancedStringSplit(s));
    }
}
