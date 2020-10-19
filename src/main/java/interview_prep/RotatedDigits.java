package main.java.interview_prep;

public class RotatedDigits {
  private boolean isValidNumber(char n) {
    if (n == '3' || n == '4' || n == '7') {
      return false;
    } else {
      return true;
    }
  }

  private char rotateNumber(char n) {
    if (n == '0' || n == '1' || n == '8') {
      return n;
    } else if (n == '5') {
      return '2';
    } else if (n == '2') {
      return '5';
    } else if (n == '6') {
      return '9';
    } else if (n == '9') {
      return '6';
    }
    return n;
  }

  public int rotatedDigits(int N) {
    int numGood = 0;
    for (int i = 1; i <= N; i++) {
      String numString = Integer.toString(i); // 170
      StringBuilder rotatedString = new StringBuilder();
      int multiplier = numString.length() - 1;
      for (int j = 0; j < numString.length(); j++) {
        char ch = numString.charAt(j);
        if (isValidNumber(ch)) {
          char rotated = rotateNumber(ch);
          rotatedString.append((rotated - '0') * (Math.pow(10, multiplier)));
          multiplier--;
        }
      }
      if (rotatedString.length() == numString.length()) {
        Integer rotatedNumber = Integer.parseInt(rotatedString.toString());
        Integer num = Integer.parseInt(numString);
        if (rotatedNumber != num) {
          numGood++;
        }
      }
    }
    return numGood;
  }
}
