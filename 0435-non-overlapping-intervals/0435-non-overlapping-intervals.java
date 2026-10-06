class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        // Sort by ending time
        Arrays.sort(intervals, (a, b) -> Integer.compare (a[1] , b[1]));

        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            // Overlap
            if (intervals[i][0] < prevEnd) {
                count++;
            }

            // No overlap
            else {
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
}

// goal is to remove min no of overlapping intervals so that remaning remains non overlap 


// so first sort it but why we sort it because jitna size bda hoga ie range utni overlsap hone ke chnces jiyda so keep the earliest one 

// overlap condition eg 1 4 and 2 3 prev end 4 and start 2 so my start start < prev end so its is overlapping 

// agar nhi overlap krrha to just prev end ko update krdo 
