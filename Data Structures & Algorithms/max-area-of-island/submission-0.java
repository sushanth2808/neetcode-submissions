class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int maxi = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]!=0){
                    int[] count = new int[1];
                    dfs(grid,i,j,count);
                    maxi=Math.max(count[0],maxi);
                }
            }
        }
        return maxi;  
    }

    private void dfs(int[][] grid, int row, int col, int[] count){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]==0){
            return;
        }
        grid[row][col]=0;
        count[0]++;
        System.out.println("count:"+count[0]);
        for(int i=0;i<4;i++){
            dfs(grid,row+dir[i][0],col+dir[i][1],count);
        }
    }
}
