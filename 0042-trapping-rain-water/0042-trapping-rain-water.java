class Solution {
    public int trap(int[] height) {
        // in order to trap waater we must have left right boundaries 
        //so here we think of two pointers 

        //1. if both bars are the of same height then water will not be stored
        //2. if they are in descending order then also water will overflow right
        //3 . if they are in ascending order left overflow
        //4. single bar then also water overflow
        //5. if two bars are there we can think of wqater can accumu;late but in actrual only water will accumulate wher curreny height is lesser than the left boundary as well as right boundary
        //6. cuurent height will not see only its exact leftmost and rightmost boundary
        // we have to see all left and right 
        // 7. find left most higher value and rightmost higher value 
        // 8 water will store to the lower value i.e max left, right then out of both min value find 
        //9 . min 3 bars required to accumulate water 
        //10. in order to find left most higher we use auxillary array in right also

        int n = height.length;

        // i will apply here the two pointer approach instead of check for every heiught its rightmost and leftmost it will give us brute force 

        // we will apply 2 pointers approach we will see if left boundary is les then left side is asy to process 

        int water = 0 ;
        int i = 0 ;
        int j = n-1;
        int leftMax= 0;
        int rightMax = 0;

        while(i < j ){
            if(height[i] <= height[j]){
                // left boundary kmhai mtlb itna pani store krvaskte agr right chose kiya overflow hojyga that means right side wall containbs jo left jitni to hsu

                if(height[i] >= leftMax){ // leftmax stores the maximum water stored in the left
                     leftMax = Math.max(height[i] , leftMax);

                }
                else{
                    water += leftMax - height[i];
                    
                }
                i++;
               
            }
            if(height[i] >=  height[j]){
                // left boundary kmhai mtlb itna pani store krvaskte agr right chose kiya overflow hojyga that means right side wall containbs jo left jitni to hsu

                if(height[j] >= rightMax){ // leftmax stores the maximum water stored in the left
                     rightMax = Math.max(height[j] , rightMax);

                }
                else{
                    water += rightMax - height[j];
                   
                }
                j--;
               
            }


        }
        return water;

      
    }
}