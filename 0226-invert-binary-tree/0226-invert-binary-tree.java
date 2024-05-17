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
    public TreeNode invertTree(TreeNode root) {

        TreeNode current = root;

        if (current==null) return root;

        TreeNode left = current.left;
        current.left = current.right;
        current.right = left;

        invertTree(current.left);     
        invertTree(current.right);  

        return root;
    }
}