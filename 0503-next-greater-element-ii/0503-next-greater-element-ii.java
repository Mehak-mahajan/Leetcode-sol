class Solution {
    public int[] nextGreaterElements(int[] nums) {

        // but here in a cicular manner 
        // monotonic stck

        Stack<Integer> st = new Stack<>();
        int n = nums.length; // whenever we talk about circular array we move twice the array
        int[] ans = new int[n];

        Arrays.fill(ans , -1);

        for(int i = 0 ; i < 2*n ; i++){
            //but original index upto n tk rhga na inorder to preserve 

            int index = i % n;

            while(!st.isEmpty() && nums[st.peek()] < nums[index]){
                int ind = st.pop();
                ans[ind] = nums[index]; // kyuki maybe i > n but ans size isn so inorder to give hat same index we use arliwer nodulo
            }

            if(i < n){
                st.push(index);
            }


        }
        return ans;


        
    }
}