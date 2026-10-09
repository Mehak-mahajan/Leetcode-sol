class Solution {
    public int findMinArrowShots(int[][] points) {

        // burst balloons first interval ka end pr humne apna phla arrow [placekia ] next intervals start than the x ie first arrow position that means arrow remain same else arrow count 

        Arrays.sort(points , (a,b) -> Integer.compare(a[1],b[1])) ;// increasing order of strting tui,e pf sarrange krdia


         int x=points[0][1]; 
          int count = 1 ; // initially arrow vo fisrt interval ke end pr hota

        //  now check start <= x haikinhi 

        for(int i = 1 ; i < points.length ; i++){
            //
            if(points[i][0] > x ){
                count++;
                x = points[i][1];

            }



        }
        return count;
        
    }
}
//: Sort by ending time because we want to place each arrow as early as possible while still bursting the current balloon. This maximizes the chance that the same arrow bursts other overlapping balloons too.