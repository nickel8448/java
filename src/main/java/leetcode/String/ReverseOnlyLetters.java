package main.java.leetcode.String;

import java.util.Stack;
import javax.swing.*;

public class ReverseOnlyLetters {
  public static String reverseOnlyLetters(String S) {
    Stack<Character> charStack = new Stack<>();
    for (char c : S.toCharArray()) {
      if (Character.isLetter(c)) {
        charStack.add(c);
      }
    }
    StringBuilder output = new StringBuilder();
    for (char c : S.toCharArray()) {
      if (Character.isLetter(c)) {
        output.append(charStack.pop());
      } else {
        output.append(c);
      }
    }
    return output.toString();
  }

  public static void main(String[] args) {
    // Output: "j-Ih-gfE-dCba"
    // Output: "Qedo1ct-eeLg=ntse-T!"
    System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
  }
}
