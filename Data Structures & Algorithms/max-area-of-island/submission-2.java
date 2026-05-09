class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int maxi = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]!=0){
                    int area = dfs(grid,i,j);
                    maxi=Math.max(area,maxi);
                }
            }
        }
        return maxi;  
    }

    private int dfs(int[][] grid, int row, int col){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]==0){
            return 0;
        }
        grid[row][col]=0;
        int area=0;
        for(int i=0;i<4;i++){
            area=area+dfs(grid,row+dir[i][0],col+dir[i][1]);
        }
        return area+1;
    }
}
