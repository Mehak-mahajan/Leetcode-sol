class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        

        int i = 0 ;
// intervals before new interval to gar newinterval ka strt greater
        while(i < intervals.length  && newInterval[0] > intervals[i][1]){
            // ex [1,5] [6,9] <<< [6,9] is new intervals its start is greater than ity prev end 
            // complete before new interval 

            result.add(intervals[i]);
            i++;
        }


        // ovrelapping intervals 

        // i have taken the example [1,3] [2,5] start < PREV END 
        while(i < intervals.length && newInterval[1] >= intervals[i][0]){

            newInterval[1] = Math.max(newInterval[1] , intervals[i][1]);
            newInterval[0] = Math.min(newInterval[0] , intervals[i][0]);

            i++;


            
        }

        result.add(newInterval);


        // while remaining add krdo 

        while(i < intervals.length){
            result.add(intervals[i]);

            i++;
        }


        return result.toArray(new int[result.size()][]);
    }
}


// insert interval 

// this ques is divided into three parts 

// new interval greater than the existing 

// new interval overlap existing 

// after inetrval existing 
