package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/decode-string/
 *
 * <p>Input: s = "3[a]2[bc]" Output: "aaabcbc"
 *
 * <p>Input: s = "3[a2[c]]" Output: "accaccacc"
 *
 * <p>Approach: Greedy approach
 *
 * <p>Complexity - O(n)
 */
public class DecodeString {
  public String decodeString(String s) {
    Stack<Integer> integerStack = new Stack<>();
    Stack<String> stringStack = new Stack<>();
    int ptr = 0;
    String result = "";
    while (ptr < s.length()) {
      char currentChar = s.charAt(ptr);
      if (Character.isDigit(currentChar)) {
        // We see a number and we add it to the stack
        int num = 0;
        while (Character.isDigit(s.charAt(ptr))) {
          num = num * 10 + (s.charAt(ptr) - '0');
          ptr++;
        }
        integerStack.push(num);
      } else if (currentChar == '[') {
        // This takes care of the nested part. Add the string which has been built
        // until now
        stringStack.push(result);
        result = "";
        ptr++;
      } else if (currentChar == ']') {
        StringBuilder str = new StringBuilder(stringStack.pop()); // Popping the previous one
        int count = integerStack.pop();
        for (int i = 0; i < count; i++) {
          str.append(result); // Appending the string we currently have
        }
        result = str.toString();
        ptr++;
      } else {
        result += s.charAt(ptr);
        ptr++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
      DecodeString d = new DecodeString();
    System.out.println(d.decodeString("3[a2[bc]]"));
  }
}
