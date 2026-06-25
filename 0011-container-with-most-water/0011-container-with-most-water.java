class Solution {
    public int maxArea(int[] height) {
        // in this only two lines are sufficient for storing water 
        // 3 bar or line not necessary 
        // width is fixed but we want max water so this can be done by 
        // max water can be stored out of left or right min boundary which is 
        //we wnat min height ko maximize kre

        int left = 0;
        int right = height.length - 1;
         int MaxArea = 0 ;
        while(left < right)   {
            int width = right - left ; // width fixed 
            int h = Math.min(height[left] , height[right]); // only height maximize kr skte min vli 
            int area = h * width;

           
            MaxArea = Math.max(area, MaxArea);
            if(height[left] < height[right]){ /// if left value less right value se because by doing this our min increase 
                left++; // by moving taller line does not make effect because min remain same but here by moving left min value increase
            }
            else{
                right--;
            }
        }   
        return MaxArea; 
    }
}