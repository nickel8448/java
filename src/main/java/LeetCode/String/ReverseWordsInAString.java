package main.java.leetcode.String;

public class ReverseWordsInAString {
    public static String reverseWords(String str) {
        if(str.equals("")) return "";
        StringBuilder outputStr = new StringBuilder();
        int wordStartIndex = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                outputStr.append(reverseWord(str.substring(wordStartIndex, i)));
                outputStr.append(' ');
                wordStartIndex = i + 1;
            }
        }
        outputStr.append(reverseWord(str.substring(wordStartIndex, str.length())));
        return outputStr.toString();
    }

    public static String reverseWord(String str) {
        StringBuilder reversedString = new StringBuilder();
        for(int i = str.length() - 1; i >=0; i--) {
            reversedString.append(str.charAt(i));
        }
        return reversedString.toString();
    }

    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(reverseWords(str));
    }
}
