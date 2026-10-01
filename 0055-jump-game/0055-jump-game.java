class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {

            // Current index is unreachable
            if (i > farthest) {
                return false;
            }

            // Update the farthest position we can reach
            farthest = Math.max(farthest, i + nums[i]);

            // We can reach the last index
            if (farthest >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}

// intuition current index + kitni jumps kr sktya that is farthest till that it is reahable if farthest >= last index return yrue but if i > farthest that means farthest is reachab;le only till that place how can we how can we go beyond that which is stuck so false 