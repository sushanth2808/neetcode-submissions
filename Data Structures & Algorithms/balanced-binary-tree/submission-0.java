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
    boolean balance = true;
    public boolean isBalanced(TreeNode root) {
        heightTree(root);
        return balance;
    }

    private int heightTree(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = heightTree(root.left);
        int right = heightTree(root.right);
        if(left-right>1 || right-left>1){
            balance=false;
        }
        return 1+Math.max(left,right);
    }
}
