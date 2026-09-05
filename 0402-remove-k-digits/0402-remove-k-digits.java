class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {

            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }

            stack.push(digit);
        }

        // If k is still remaining, remove from the end
        while (k > 0) {
            stack.pop();
            k--;
        }

        // Build answer and remove leading zeros
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;

        for (char digit : stack) {
            if (leadingZero && digit == '0') {
                continue;
            }

            leadingZero = false;
            sb.append(digit);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}