class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int perimeter =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    perimeter= dfs(i,j,grid,n,m);
                    break;
                    }
                }
            }
            return perimeter;
        }

    private int dfs(int row,int col, int[][] grid,int n,int m){
        if(row>=n || col>=m || col<0 || row<0 || grid[row][col]==0){
            return 1;
        }
        if(grid[row][col]==-1){
            return 0;
        }
        grid[row][col]=-1;
        int perimeter=0;
        for(int i=0;i<4;i++){
            perimeter+=dfs(row+dir[i][0],col+dir[i][1],grid,n,m);
        }
        return perimeter;
    }
}