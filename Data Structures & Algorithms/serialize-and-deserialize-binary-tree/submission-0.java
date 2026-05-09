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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node!=null){
                q.add(node.left);
                q.add(node.right);
                str.append(node.val);
            }
            else{
                str.append("$");
            }
            str.append("#");
        }
        System.out.println(str.toString());
        return str.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split("#");
        int n = str.length-1;
        if(str[0].equals("$")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for(int i=0;i<str.length;i++){
            TreeNode node = q.poll();
            if(2*i+1<n && !str[2*i+1].equals("$")){
                TreeNode leftNode = new TreeNode(Integer.parseInt(str[2*i+1]));
                node.left = leftNode; 
                q.offer(leftNode);
            }
            if(2*i+2<n && !str[2*i+2].equals("$")){
            TreeNode rightNode = new TreeNode(Integer.parseInt(str[2*i+2]));
            node.right = rightNode;
            q.offer(rightNode);
            }  
        }
        return root;
        
    }
}
