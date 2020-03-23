package main.java.LeetCode.String;

public class JudgeCircle {
    public static boolean judgeCircle(String moves) {
        if(moves.length() == 0) return true;
        int verticalBalance = 0;
        int horizontalBalance = 0;
        for(int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'U':
                    verticalBalance++;
                    break;
                case'D':
                    verticalBalance--;
                    break;
                case'L':
                    horizontalBalance++;
                    break;
                case'R':
                    horizontalBalance--;
                    break;
            }
        }
        return (verticalBalance == 0 && horizontalBalance == 0);
    }

    public static void main(String[] args) {
        System.out.println(judgeCircle("UD"));
        System.out.println(judgeCircle("LL"));

    }
}
