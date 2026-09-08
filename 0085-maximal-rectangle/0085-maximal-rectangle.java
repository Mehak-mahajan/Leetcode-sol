import java.util.*;

class Solution {

    public int maximalRectangle(char[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {

            // Step 1: Build histogram for current row
            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == '1') {
                    heights[j] ++;
                } else {
                    heights[j] = 0;
                }
            }

            // Step 2: Find largest rectangle in this histogram
            Stack<Integer> st = new Stack<>();

            for (int j = 0; j <= cols; j++) {

                int currentHeight =
                    (j == cols) ? 0 : heights[j];

                while (!st.isEmpty() &&
                       heights[st.peek()] > currentHeight) {

                    int height = heights[st.pop()];

                    int width;

                    if (st.isEmpty()) {
                        width = j;
                    } else {
                        width = j - st.peek() - 1;
                    }

                    int area = height * width;

                    maxArea = Math.max(maxArea, area);
                }

               // if (j < cols) {
                    st.push(j);
                // }
            }
        }

        return maxArea;
    }
}