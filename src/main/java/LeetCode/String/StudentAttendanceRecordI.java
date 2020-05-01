package main.java.leetcode.String;

public class StudentAttendanceRecordI {
    /**
     * Problem: https://leetcode.com/problems/student-attendance-record-i/
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {
        char[] strArray = s.toCharArray();
        int numAbsents = 0;
        for(int i = 0; i < strArray.length; i++) {
            if(strArray[i] == 'A') {
                numAbsents++;
                if(numAbsents > 1)
                    return false;
            } else if(strArray[i] == 'L') {
                int lateCount = 1;
                for(int j = i + 1; j < strArray.length; j++) {
                    if(strArray[j] == 'L')
                        lateCount++;
                    else
                        break;
                }
                if(lateCount > 2)
                    return false;
            }
        }
        return true;
    }
}
