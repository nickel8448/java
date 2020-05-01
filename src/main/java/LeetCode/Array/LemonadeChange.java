package main.java.leetcode.Array;

public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        int[] numBills = new int[3];  // 5, 10 and 20 bills count
        for(int i = 0; i < bills.length; i++) {
            int bill = bills[i];
            switch (bill) {
                case 5:
                    numBills[0]++;
                    break;
                case 10:
                    numBills[1]++;
                    numBills[0]--;
                    if(numBills[0] < 0)
                        return false;
                    break;
                case 20:
                    numBills[2]++;
                    if(numBills[1] < 0) {
                        numBills[0] -= 3;
                        if(numBills[0] <= 0)
                            return false;
                    } else {
                        numBills[1]--;
                        numBills[0]--;
                        if(numBills[0] < 0 || numBills[1] < 0)
                            return false;
                    }
                    break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5,5,10,10,20};
        System.out.println(lemonadeChange(bills));
    }
}
