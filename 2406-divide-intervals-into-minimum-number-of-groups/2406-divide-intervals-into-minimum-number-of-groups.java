import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minGroups(int[][] intervals) {

        // Sort intervals by starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Min Heap stores the ending times of groups
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            // If a group is available, reuse it
            if (!pq.isEmpty() && pq.peek() < start) {
                pq.poll();
            }

            // Add the ending time of the current interval
            pq.offer(end);
        }

        // Heap size = minimum number of groups required
        return pq.size();
    }
}

//If the earliest-ending group is free, remove its old ending time and reuse the group.

// Otherwise, keep all existing groups and effectively create a new one by inserting the current ending time.

// The heap's size therefore tracks the minimum number of groups required.

/// humne ooverlapping ntervals ko bhi place krna but agr iska ending time jldi khtm horha next start greater that means vo group use krskye 