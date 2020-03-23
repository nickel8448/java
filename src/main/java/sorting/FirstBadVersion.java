package main.java.sorting;

public class FirstBadVersion {
    static int numCalls = 0;
    public static int firstBadVersion(int n) {
        int left = 0, right = n;
        while(left < right) {
            int midPoint = left + (right - left) / 2;
            if(isBadVersion(midPoint)) {
                right = midPoint;
            } else {
                left = midPoint + 1;
            }
        }
        if(left == right && isBadVersion(left)) return left;
        else return -1;
    }

    private static boolean isBadVersion(int n) {
        ++numCalls;
        return (n >= 54);
    }

    public static void main(String[] args) {

        System.out.println(firstBadVersion(100));
        System.out.println(numCalls);
    }
}
