class Solution {

    class Node{
        Node[] node = new Node[26];
        boolean end;
    }

    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(String word: words){
            Node curr = root;
            for(char c: word.toCharArray()){
                int idx = c-'a';
                Node temp = curr.node[idx];
                if(temp==null){
                    curr.node[idx]=new Node();
                }
                curr=curr.node[idx];
            }
            curr.end = true;
        } 
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                boolean[][] used = new boolean[board.length][board[0].length];
                find(board,i,j,root,res,new StringBuilder(),used);
            }
        };
        return res;
    }

    private void find(char[][] board,int row, int col, Node curr, List<String> res,StringBuilder s,boolean[][] used){
        if(row<0 || col<0 || row>=board.length || col>=board[0].length
        || used[row][col] || curr.node[board[row][col]-'a']==null){
            return;
        }
        char c = board[row][col];
        curr = curr.node[c-'a'];
        s.append(c);
        used[row][col]=true;
        if(curr.end){
            res.add(s.toString());
            curr.end = false;
        }
        for(int i=0;i<4;i++){
            find(board,row+dir[i][0],col+dir[i][1],curr,res,s,used);
        }
        s.deleteCharAt(s.length()-1);
        used[row][col]=false;
    }
}
