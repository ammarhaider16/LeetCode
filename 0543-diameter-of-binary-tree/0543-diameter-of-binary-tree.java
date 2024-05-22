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


    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int maxLen = 0;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        while (q.size() != 0) {
            TreeNode currRoot = q.poll();

            if (currRoot.left != null)
                q.add(currRoot.left);

            if (currRoot.right != null)
                q.add(currRoot.right);

            int currLen = maxDepthLR(currRoot);
            if (currLen > maxLen)
                maxLen = currLen;

        }

        return maxLen;

    };

    public int maxDepthLR(TreeNode root) {
        if (root == null)
            return 0;
        return maxDepth(root.right) + maxDepth(root.left);
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return (1 + Math.max(maxDepth(root.right), maxDepth(root.left)));
    }
}

