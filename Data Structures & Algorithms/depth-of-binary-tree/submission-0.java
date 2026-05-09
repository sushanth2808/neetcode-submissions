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
    private int maxDepth = 0;
    private int depth =0;
    public int maxDepth(TreeNode root) {
        if(root==null){
            maxDepth = Math.max(depth,maxDepth);
            return maxDepth;
        }
        depth++;
        maxDepth(root.left);
        maxDepth(root.right);
        depth--;
        return maxDepth;
    }
}
