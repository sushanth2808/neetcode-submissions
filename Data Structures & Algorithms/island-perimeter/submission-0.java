class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int perimeter =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    for(int k=0;k<4;k++){
                        int row=i+dir[k][0];
                        int col = j+dir[k][1];
                        if(row>=n || col>=m || col<0 || row<0 || grid[row][col]==0){
                            perimeter+=1;
                        }
                    }
                }
            }
        }
        return perimeter;
    }

}