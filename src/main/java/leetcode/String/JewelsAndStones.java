package main.java.leetcode.String;

public class JewelsAndStones {

    public static int numJewelsInStones(String J, String S) {
        if((J == null || S == null) || (J.equals("") || S.equals(""))) return 0;
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < J.length(); j++) {
                if(S.charAt(i) == J.charAt(j)) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String J = "zzzzzzzz";
        String S = "z";
        System.out.println(numJewelsInStones(J, S));
    }
}
