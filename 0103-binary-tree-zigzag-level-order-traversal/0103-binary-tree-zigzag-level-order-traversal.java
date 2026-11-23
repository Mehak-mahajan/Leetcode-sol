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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean flag = true;

        while (!queue.isEmpty()) {

            int size = queue.size();
         List<Integer> level = new ArrayList<>(
    Collections.nCopies(size, 0)
);
            for (int i = 0; i < size; i++) {

                int index;

                TreeNode node = queue.poll();

                if (flag) {
                     //level.add( node.val);
                    index = i;
                } else {
//level.add(0, node.val); /// values added at the beginning 
                      // abh yh left to right move nhi krga 

                      index = size - i-1;
                }
                level.set(index , node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result.add(level);

            flag = !flag; // jb value left to right hogi uske bd rflag ko chnge krdo
        }

        return result;
    }
}

//traversal o(n2)