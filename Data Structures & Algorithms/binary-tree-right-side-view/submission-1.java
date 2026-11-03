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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        find(root,res,new HashSet<>(),0);
        return res;
    }

    private void find(TreeNode root, List<Integer> res,Set<Integer> visited,int level){
        if(root==null){
            return;
        }
        if(!visited.contains(level)){
            res.add(root.val);
            visited.add(level);
        }
        find(root.right,res,visited,level+1);
        find(root.left,res,visited,level+1);
    }
}
