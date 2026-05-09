class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count =0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]!='0'){
                    count++;
                    findIsland(grid,i,j);
                }
            }
        }
        return count;
    }

    private void findIsland(char[][] grid, int row,int col){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]=='0'){
            return;
        }
        grid[row][col]='0';
        for(int i=0;i<4;i++){
            findIsland(grid,row+dir[i][0],col+dir[i][1]);
        }
    }
}
