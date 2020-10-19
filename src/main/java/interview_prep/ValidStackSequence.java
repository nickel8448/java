package main.java.interview_prep;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/validate-stack-sequences/
 *
 * <p>Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1] Output: true Explanation: We might do the
 * following sequence: push(1), push(2), push(3), push(4), pop() -> 4, push(5), pop() -> 5, pop() ->
 * 3, pop() -> 2, pop() -> 1
 *
 * <p>Approach: Greedy approach
 *
 * <p>Complexity - O(n)
 */
public class ValidStackSequence {
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    Stack<Integer> stack = new Stack<>();
    int i = 0;
    for (int x : pushed) {
      stack.push(x);
      while (!stack.isEmpty() && stack.peek() == popped[i]) {
        stack.pop();
        i++;
      }
    }
    return stack.isEmpty();
  }
}
