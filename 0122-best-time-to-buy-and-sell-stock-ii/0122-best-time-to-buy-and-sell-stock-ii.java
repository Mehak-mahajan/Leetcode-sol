class Solution {
    public int maxProfit(int[] prices) {

         int answer = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                answer += prices[i + 1] - prices[i];
            }
        }

        return answer;

        
    }
}

// it is 2nd trype based on greedy approach where we can amke multiple transaction whre the value at the first higer then next drops ie it decreaes we dont include we only include where it is being higher into ans 