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
    public int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findSum(root);
        return maxSum;
    }

    public int findSum(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = findSum(root.left);
        int right = findSum(root.right);
        int sum =  Math.max(left+right,Math.max(left,right));
        int rootSum = Math.max(root.val,sum+root.val);
        maxSum = Math.max(rootSum, maxSum);
        System.out.println("sum: "+rootSum);
        return Math.max(root.val,Math.max(left,right)+root.val);
    }

    
}
