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
    public boolean isBalanced(TreeNode root) {

        if (root == null) return true;

        int leftH = maxHeight(root.left);
        int rightH = maxHeight(root.right);
        if (Math.abs(leftH - rightH)>1) return false;

        if (!isBalanced(root.right)) return false; 
        if (!isBalanced(root.left)) return false; 
        return true;
    }


    public int maxHeight (TreeNode root) {

        if (root == null) return 0;
        return (1 + Math.max(maxHeight(root.right), maxHeight(root.left)));
    }
}