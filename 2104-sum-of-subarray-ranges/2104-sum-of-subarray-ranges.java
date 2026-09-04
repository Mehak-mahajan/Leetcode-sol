class Solution {
    public long subArrayRanges(int[] nums) {


        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] minprev = new int[n];
         // stores left values

         int[] minnext = new int[n];

        // as we r finding subarrays so that we have to maintain the equality and strict so that no value can be calculated twice 
        //next smaller elemnt to left 

        for(int i = 0; i < n ; i++){

            while(!st.isEmpty() && nums[st.peek()] >= nums[i] ){
                // that means a smaller elemnt is arrived 
                st.pop();
            }
            if(st.isEmpty()){
                minprev[i] = -1;
            }
            else{
                minprev[i] = st.peek(); // stack mein smaller elemnt vo aygfa 
            }

            st.push(i);

        }
        st.clear(); // because we have to fill now from right side


          for(int i = n-1; i >=0 ; i--){

            while(!st.isEmpty() && nums[st.peek()] > nums[i] ){
                // that means a smaller elemnt is arrived 
                st.pop();
            }
            if(st.isEmpty()){
                minnext[i] = n; // as here we have to fins the for left i - prev and for right next - i if i write next = -1 it give sum minus value so we write if it doen niot exist nj 
            }
            else{
                minnext[i] = st.peek(); // stack mein smaller elemnt vo aygfa 
            }

            st.push(i);

        }

        // now in ques explicitly given that ans may be might long

        long minsum = 0;

         //int MOD = 1_000_000_007;

        for (int i = 0; i < n; i++) {

            long minleft = i - minprev[i];
            long minright = minnext[i] - i;

            long contribution =   (long) nums[i] * minleft * minright;

            minsum = minsum + contribution;
        }

       

        // finding the next greater elemnt to right 

        st.clear();

      
        // prev greater elemnt

        int[] prevMax = new int[n];
        int[] nextMax = new int[n];

        // Previous Greater
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() &&
                   nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            prevMax[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        } 

        st.clear();





 // Next Greater or Equal
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() &&
                   nums[st.peek()] < nums[i]) {
                st.pop();
            }

            nextMax[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        long maxsum = 0;

         //int MOD = 1_000_000_007;

        for (int i = 0; i < n; i++) {

            long maxleft = i - prevMax[i];
            long maxright = nextMax[i] - i;

            long contributions =   (long) nums[i] * maxleft * maxright;

            maxsum = maxsum + contributions;
        }


        return maxsum - minsum;


        
    }
}