class Solution {
    public int sumSubarrayMins(int[] arr) {

        // key idea is for every eklement wefind next smaller elemnt on left as well as on right

        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] prev = new int[n];
         // stores left values

         int[] next = new int[n];

        // as we r finding subarrays so that we have to maintain the equality and strict so that no value can be calculated twice 
        //next smaller elemnt to left 

        for(int i = 0; i < n ; i++){

            while(!st.isEmpty() && arr[st.peek()] >= arr[i] ){
                // that means a smaller elemnt is arrived 
                st.pop();
            }
            if(st.isEmpty()){
                prev[i] = -1;
            }
            else{
                prev[i] = st.peek(); // stack mein smaller elemnt vo aygfa 
            }

            st.push(i);

        }
        st.clear(); // because we have to fill now from right side


          for(int i = n-1; i >=0 ; i--){

            while(!st.isEmpty() && arr[st.peek()] > arr[i] ){
                // that means a smaller elemnt is arrived 
                st.pop();
            }
            if(st.isEmpty()){
                next[i] = n; // as here we have to fins the for left i - prev and for right next - i if i write next = -1 it give sum minus value so we write if it doen niot exist nj 
            }
            else{
                next[i] = st.peek(); // stack mein smaller elemnt vo aygfa 
            }

            st.push(i);

        }

        // now in ques explicitly given that ans may be might long

        long sum = 0;

         int MOD = 1_000_000_007;

        for (int i = 0; i < n; i++) {

            long left = i - prev[i];
            long right = next[i] - i;

            long contribution =   (long) arr[i] * left * right;

            sum = (sum + contribution) % MOD;
        }

        return (int) sum;



        
    }
}