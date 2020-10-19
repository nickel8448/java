package main.java.interview_prep;

import java.util.*;

/**
 * Problem:
 *
 * <p>Approach: 1) Create a priority queue for each worker with
 *
 * <p>Runtime: O(n*m*log(nm))
 */
public class CampusBikes {

  private class BikeNode {
    int distance;
    int worker;
    int bike;

    BikeNode(int distance, int worker, int bike) {
      this.distance = distance;
      this.worker = worker;
      this.bike = bike;
    }
  }

  public int[] assignBikes(int[][] workers, int[][] bikes) {
    int n = workers.length;
    PriorityQueue<BikeNode> bikeQueue =
        new PriorityQueue<>(
            new Comparator<BikeNode>() {
              @Override
              public int compare(BikeNode b1, BikeNode b2) {
                int distanceCompare = Integer.compare(b1.distance, b2.distance);
                if (distanceCompare == 0) {
                  int workerCompare = Integer.compare(b1.worker, b2.worker);
                  if (workerCompare == 0) return Integer.compare(b1.bike, b2.bike);
                  return workerCompare;
                }
                return distanceCompare;
              }
            });
    for (int i = 0; i < workers.length; i++) {
      for (int j = 0; j < bikes.length; j++) {
        int[] worker = workers[i];
        int[] bike = bikes[j];
        int manhattanDistance = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
        bikeQueue.add(new BikeNode(manhattanDistance, i, j));
      }
    }

    int[] res = new int[n];
    Arrays.fill(res, -1);
    Set<Integer> bikeAssigned = new HashSet<>();
    while (bikeAssigned.size() < n) {
      BikeNode currentBike = bikeQueue.poll();
      if (res[currentBike.worker] == -1 && !bikeAssigned.contains(currentBike.bike)) {
        res[currentBike.worker] = currentBike.bike;
        bikeAssigned.add(currentBike.bike);
      }
    }
    return res;
  }
}
