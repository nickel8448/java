package main.java.CodeForces.CROC;

import java.util.Scanner;

/**
 * Problem: https://codeforces.com/problemset/problem/245/A
 */
public class SystemAdministrator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] packets = new int[2][2];
        for(int i = 0; i < n; i++) {
            int server = sc.nextInt();
            packets[server - 1][0] += sc.nextInt();
            packets[server - 1][1] += sc.nextInt();
        }
        for(int i = 0; i < 2; i++) {
            int packetsSent = packets[i][1];
            int packetsReceived = packets[i][0];
            int totalPackets = packetsReceived + packetsSent;
            if(packetsReceived >= totalPackets / 2) {
                System.out.println("LIVE");
            } else {
                System.out.println("DEAD");
            }
        }
    }
}
