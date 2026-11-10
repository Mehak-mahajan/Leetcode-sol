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
    public boolean isSameTree(TreeNode p, TreeNode q) {



        if (p == null && q == null) {
        return true;

        //both ended at same position
    }

    if (p == null || q == null || p.val != q.val) {
        return false;

        // p null hai and q null nhi false
        //q null and p not null false 
        // dono null hai and value same hai that means left right subtree explore hogi 3 condition use hogi sime 

        // dono nulll hai pr value diff hai false 

    }

    return isSameTree(p.left, q.left) &&
           isSameTree(p.right, q.right);
        
    }
}