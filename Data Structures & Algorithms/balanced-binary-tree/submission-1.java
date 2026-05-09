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
        int[] bool = balance(root);
        if(bool[1]==0){
            return true;
        }
        return false;
    }

    private int[] balance(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }

        int[] left = balance(root.left);
        int[] right = balance(root.right);
        if(Math.abs(left[0]-right[0])<=1 && left[1]==0 && right[1]==0){
             return new int[]{1+Math.max(left[0],right[0]),0};
        }
        return new int[]{1+Math.max(left[0],right[0]),1};
    }
}
