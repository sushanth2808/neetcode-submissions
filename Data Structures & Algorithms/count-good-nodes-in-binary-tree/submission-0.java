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
    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        int max = root.val;
        int[] res = new int[1];
        findGood(root,max,res);
        return res[0];
    }

    private void findGood(TreeNode root,int max,int[] res){
        if(root==null){
            return;
        }
        if(root.val>=max){
            res[0]++;
        }
   
        max = Math.max(max,root.val);
        
        findGood(root.left,max,res);
        findGood(root.right,max,res);

    }
}
