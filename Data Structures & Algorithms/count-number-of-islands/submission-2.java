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
        grid[row][col]='0';
        for(int i=0;i<4;i++){
        if(row+dir[i][0]<0 || col+dir[i][1]<0 || row+dir[i][0]>=grid.length || col+dir[i][1]>=grid[0].length || grid[row+dir[i][0]][col+dir[i][1]]=='0'){
            continue;
        }
            findIsland(grid,row+dir[i][0],col+dir[i][1]);
        }
    }
}
