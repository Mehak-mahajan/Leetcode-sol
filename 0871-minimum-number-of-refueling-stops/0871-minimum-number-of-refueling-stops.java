
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder()); // max heap 

        int farthest = startFuel;
        int stops = 0;
        int i = 0;

        while (farthest < target) {

            // Add fuel from all stations we can currently reach
            while (i < stations.length && stations[i][0] <= farthest) {
                maxHeap.offer(stations[i][1]);
                i++;
            }

            // No reachable station has fuel available
            if (maxHeap.isEmpty()) {
                return -1;
            }

            // Refuel using the station with maximum fuel
            farthest += maxHeap.poll();
            stops++;
        }

        return stops;
    }
}

// we dont do fueling at every station we do fueling only when we cant reach the enxt station out of fuel running 
// we have to reacgh the goal so if is in the heap value exist so we refuel it 