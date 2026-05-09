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
    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[1];
        TreeNode res = findKNode(root,k,count);
        if(res!=null){
            return res.val;
        }
        else{return 0;}
    }

    private TreeNode findKNode(TreeNode root, int k, int[] count){
        if(root==null){
            return null;
        }
        TreeNode left = findKNode(root.left,k,count);
        if(left!=null){return left;}

        count[0]+=1;
        if(count[0]==k){return root;}
        
        
        return findKNode(root.right,k,count);

   

    }
}
