import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] prev = new int[n];
        int[] next = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous Smaller
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                prev[i] = -1;
            } else {
                prev[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();

        // Next Smaller
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                next[i] = n;
            } else {
                next[i] = st.peek();
            }

            st.push(i);
        }

        // Calculate maximum area
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            int width = next[i] - prev[i] - 1;

            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}


//umm here key idea is thta we have to find the largest rectangle till the we have to go till righta nd left until the smaller boundary hits we have ti stop over there b.. for this we have to find the prev smaller next smaller so like here in example 2 smaller prev = 1 and next greater = 10 

// width = next - prev - i ; area = current height * width just maxarea calculate mat.max