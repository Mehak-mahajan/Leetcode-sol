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
    public int maxDepth(TreeNode root) {

        // as yh leaf node pr jarha to agr humri root 0 hogi to to vo node t exist krti na isliye we add 1 

        // first explore left

        if(root == null){
            return 0;
        }

        int leftdepth = maxDepth(root.left);

        int rightdepth = maxDepth(root.right);

        return 1+ Math.max(leftdepth,rightdepth);
        
    }
}