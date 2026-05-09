class Solution {
    int[][] dir = {{1,0},{0,1},{0,-1},{-1,0}};
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O')
                {
                    int[][] used = new int[board.length][board[0].length];
                    boolean isValid = dfs(board,i,j,used);
                    System.out.println("row:"+i+" col:"+j+"-"+isValid);
                    if(isValid){
                        changeDfs(board,i,j);
                    }
                }
            }
        }
    }


        private void changeDfs(char[][] board, int row, int col){
        if(row<0 || col<0 || row>=board.length || col>=board[0].length || board[row][col]=='X'){
            return ;
        }
        board[row][col]='X';
        for(int i=0;i<4;i++){
            int r = row+dir[i][0];
            int c = col+dir[i][1];
            changeDfs(board,r,c);
                
        }
    }

    private boolean dfs(char[][] board, int row, int col,int[][] used){
        if(row<0 || col<0 || row>=board.length || col>=board[0].length){
    return false; // escaping → not surrounded
}
        if(board[row][col]=='X' || used[row][col]==1){
            return true;
        }
        if(row==0 || col==0 || row==board.length-1|| col==board[0].length-1){
            return false;
        }
        used[row][col]=1;
        for(int i=0;i<4;i++){
            int r = row+dir[i][0];
            int c = col+dir[i][1];
            if(dfs(board,r,c,used)==false){
                return false;
            }
        }
        return true;
    }
}
