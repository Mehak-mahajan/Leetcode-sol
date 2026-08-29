class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // next graete elemnt find krna

        int n = nums2.length;

        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){

            while(!st.isEmpty() && st.peek() < nums2[i]){
                map.put(st.pop(), nums2[i]);

            }
            st.push(nums2[i]);

        }

        int[] ans = new int[nums1.length];
         for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }

        return ans;


        
    }
}