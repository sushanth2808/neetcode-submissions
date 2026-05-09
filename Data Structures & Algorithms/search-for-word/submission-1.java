class Solution {
    int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] used = new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(checkForLetter(board,word,i,j,0,used)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkForLetter(char[][] board,String word,int row,int col,int wordIndex,boolean[][] used){

        

        if (row < 0 || row >= board.length || 
            col < 0 || col >= board[0].length
            || used[row][col] ||  word.charAt(wordIndex)!=board[row][col]) {
                return false;
        }
        if(wordIndex==word.length()-1){return true;}

        used[row][col]=true;

        for(int i=0;i<4;i++){
            if(checkForLetter(board,word,row+dir[i][0],col+dir[i][1],wordIndex+1,used)){
                return true;
            }
        }

        used[row][col]=false;
        return false;
    }
}
