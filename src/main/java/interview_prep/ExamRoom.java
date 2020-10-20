package main.java.interview_prep;

import java.util.*;

/** Problem: https://leetcode.com/problems/exam-room/ */
public class ExamRoom {
  int seatsOccupied;
  int[] leftDistance;
  int[] rightDistance;
  boolean[] occupied;
  int nextSeat;
  boolean isNextSeatFound;
  int N;

  public ExamRoom(int N) {
    leftDistance = new int[N];
    rightDistance = new int[N];
    Arrays.fill(leftDistance, N - 1);
    Arrays.fill(rightDistance, N - 1);
    seatsOccupied = 0;
    occupied = new boolean[N];
    isNextSeatFound = false;
    this.N = N;
  }

  public int seat() {
    if (seatsOccupied == 0) {
      occupied[0] = true;
      seatsOccupied++;
      return 0;
    } else {
      seatsOccupied++;
      if (!isNextSeatFound) {
        nextSeat = updateLeftAndRightAndReturnSeat();
        occupied[nextSeat] = true;
        return nextSeat;
      } else {
        isNextSeatFound = false;
        return nextSeat;
      }
    }
  }

  public void leave(int p) {
    occupied[p] = false;
    nextSeat = updateLeftAndRightAndReturnSeat();
    isNextSeatFound = true;
    seatsOccupied--;
  }

  private int updateLeftAndRightAndReturnSeat() {
    // Update the left and right array with the distance from the student on
    // the left and right respectively
    for (int i = 0; i < N; i++) {
      if (occupied[i] || i == 0) {
        leftDistance[i] = 0;
      } else {
        leftDistance[i] = leftDistance[i - 1] + 1;
      }
    }
    for (int i = N - 1; i >= 0; i--) {
      if (occupied[i] || i == N - 1) {
        rightDistance[i] = 0;
      } else {
        rightDistance[i] = rightDistance[i + 1] + 1;
      }
    }

    // Find the seat with maximum distance
    int maximumDistance = Integer.MIN_VALUE;
    int nextSeatForStudent = Integer.MAX_VALUE;
    for (int i = 0; i < N; i++) {
      int currentMaximum = Math.max(maximumDistance, Math.min(leftDistance[i], rightDistance[i]));
      if (currentMaximum != maximumDistance) {
        maximumDistance = currentMaximum;
        nextSeatForStudent = Math.min(nextSeatForStudent, i);
      }
    }
    return nextSeatForStudent;
  }
}
