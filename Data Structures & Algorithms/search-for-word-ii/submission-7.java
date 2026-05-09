class Solution {

    class Node{
        Node[] node = new Node[26];
        String end;
        int refs=0;
    }

    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        List<String> res = new ArrayList<>();
        for(String word: words){
            Node curr = root;
            for(char c: word.toCharArray()){
                int idx = c-'a';
                if(curr.node[idx]==null){
                    curr.node[idx]=new Node();
                }
                curr.refs++;
                curr=curr.node[idx];
            }
            curr.end = word;
        } 
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                find(board,i,j,root,res,null);
            }
        };
        return res;
    }

    private void find(char[][] board,int row, int col, Node curr, List<String> res,Node prev){
        if(row<0 || col<0 || row>=board.length || col>=board[0].length
        || board[row][col]=='#' || curr.node[board[row][col]-'a']==null){
            return;
        }
        if(prev!=null){
            if(prev.refs==0){
                prev = null;
            }
        }
        char c = board[row][col];
        Node temp = curr.node[c-'a'];
        board[row][col]='#';
        if(temp.end!=null){
            if(prev!=null){
                prev.refs--;
            }
            res.add(temp.end);
            temp.end = null;
        }
        for(int i=0;i<4;i++){
            find(board,row+dir[i][0],col+dir[i][1],temp,res,curr);
        }
         board[row][col]=c;
    }
}
