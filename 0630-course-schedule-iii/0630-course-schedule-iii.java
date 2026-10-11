import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int scheduleCourse(int[][] courses) {

        // Sort courses by increasing deadline

        // jitni jldi deadlie khtm hoi utne max course ko chance milga complete hone ka 
        Arrays.sort(courses, (a, b) ->
            Integer.compare(a[1], b[1])
        );

        // Max Heap stores selected course durations
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        int totalTime = 0;

        for (int[] course : courses) {
            int duration = course[0];
            int deadline = course[1];

            // Select the current course
            pq.offer(duration);
            totalTime += duration;

            // If we exceed the deadline, remove the longest course
            if (totalTime > deadline) {
                totalTime -= pq.poll();
            }
        }

        // Number of courses still selected
        return pq.size();
    }
}


// intuition is based on priority queue 

// why used priority queue 
// agar vo deadline se increase hohta to consa course rempve krti ofcourse longest duration ko revve knrge 

// goal find max no of courses can be completed in given deadline 

// abh deadline se excede hoge to highest duration ko rmove krna so hum heap mein dusration store krvaynge 