package main.java.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    backtrack(result, "", 0, 0, n);
    return result;
  }

  private void backtrack(List<String> result, String str, int open, int close, int n) {
    if (str.length() == n * 2) {
      result.add(str);
      return;
    } else {
      if (open < n) backtrack(result, str + "(", open + 1, close, n);
      if (close < open) backtrack(result, str + ")", open, close +1 , n);
    }
  }

    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        System.out.println(gp.generateParenthesis(3));
    }
}
