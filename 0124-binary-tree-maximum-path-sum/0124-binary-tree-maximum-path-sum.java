/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxSum = Integer.MIN_VALUE; // humme sbse choti value ko assign krlia 

    // 3 cases
    // ki agr humara left and right dono positive hai trhen we include both left and right and root value we cant return the sum of theirs to the parent bcoz when we have to traverse back bidirectional when can traverse onlychossing either of left or right 

    // second case if both are negative then only root value plus 

    // if either one of them is negative max(left,right)+ root.val 

    

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, maxGain(root.left));
        int right = Math.max(0, maxGain(root.right));

        // Maximum path passing through the current node
        maxSum = Math.max(maxSum, left + right + root.val);

        // Return only one branch to the parent
        return root.val + Math.max(left, right);
    }
}