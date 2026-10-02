class Solution {
    public int jump(int[] nums) {

        // in this ques we have to state that how many jums being required to reach the final destination 

        int count = 0 ; // min jumps being required 
        int end = 0 ; // key intuition when we jump when the range is ehausted so the end is basically the range 
        int farthest = 0;

        for(int i = 0 ; i < nums.length -1 ; i++){


            farthest = Math.max(farthest, i + nums[i]);

            if (i == end ){
                // meri range exhayst hogi now i have to jump
                count++;
                end = farthest;


                 if( farthest >= nums.length -1){
                return count;
            }



            }

           




        }
        return count;
        
    }
}