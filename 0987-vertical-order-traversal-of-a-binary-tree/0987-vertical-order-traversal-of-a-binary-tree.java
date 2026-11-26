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

    // Stores a node along with its row and column
    static class Info {
        TreeNode node;
        int row;
        int col;

        Info(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<int[]> nodes = new ArrayList<>();
        Queue<Info> queue = new LinkedList<>();

        queue.offer(new Info(root, 0, 0));

        // 1. BFS: store row, column, and node value
        while (!queue.isEmpty()) {
            Info current = queue.poll();

            TreeNode node = current.node;
            int row = current.row;
            int col = current.col;

            nodes.add(new int[]{row, col, node.val});

            if (node.left != null) {
                queue.offer(new Info(node.left, row + 1, col - 1));
            }

            if (node.right != null) {
                queue.offer(new Info(node.right, row + 1, col + 1));
            }
        }

        // 2. Sort by column, then row, then value
        Collections.sort(nodes, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];  // column
            }
            if (a[0] != b[0]) {
                return a[0] - b[0];  // row
            }
            return a[2] - b[2];      // value
        });

        // 3. Group values by column
        List<List<Integer>> answer = new ArrayList<>();
        int previousCol = Integer.MIN_VALUE;

        for (int[] entry : nodes) {
            int col = entry[1];
            int value = entry[2];

            if (col != previousCol) {
                answer.add(new ArrayList<>());
                previousCol = col;
            }

            answer.get(answer.size() - 1).add(value);
        }

        return answer;
    }
}

// we want those nodes which lies in the same line but what if they are overlapping we neeed the smallest avlue first but if they have same col then there is need of row first we do bfs traversal as we want the same col value smae hai unko group krna to ehen we move left we decreased by 1 and when increased by 1abh jinki value same hai unko same group mein rkhna 