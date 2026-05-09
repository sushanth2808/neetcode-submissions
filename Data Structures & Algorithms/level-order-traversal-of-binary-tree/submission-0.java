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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        int depth=0;
        getOrder(root,list,depth);
        return list;
    }
    private void getOrder(TreeNode root, List<List<Integer>> list, int depth){
        if(root==null){
            return;
        }
        if(list.size()<=depth){
            List<Integer> l = new ArrayList<>();
            l.add(root.val);
            list.add(l);
        }
        else{
            list.get(depth).add(root.val);
        }
        getOrder(root.left,list,depth+1);
        getOrder(root.right,list,depth+1);
    }
}
