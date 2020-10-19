package main.java.interview_prep;

public class CheckRecord {
  public boolean checkRecord(String s) {
    int numAbsent = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'A') {
        numAbsent += 1;
      } else if (s.charAt(i) == 'L') {
        int numLate = 1;
        for (int j = i + 1; j < Math.min(s.length(), i + 3); j++) {
          if (s.charAt(j) == 'L') numLate += 1;
        }
        if (numLate > 2) {
          return false;
        }
      }
      if (numAbsent > 1) {
        return false;
      }
    }
    return true;
  }
}
