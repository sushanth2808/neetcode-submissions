class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int[] pa = new int[2];
                int[][] used = new int[row][col];
                dfs(heights,i,j,pa,used);
                if(pa[0]==1 && pa[1]==1){
                    res.add(new ArrayList<>(List.of(i,j)));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int row, int col,int[] pa,int[][] used){
            if(row==0 || col ==0){
                pa[0]=1; 
            }
            if(row == grid.length-1 || col == grid[0].length-1){
                pa[1]=1;
            }
            if((row==0 && col == grid[0].length-1) || (row==grid.length-1 && col==0)){
                pa[0]=1; 
                pa[1]=1;
            }
            if(pa[0]==1 && pa[1]==1){
                return;
            }
        for(int i=0;i<4;i++){
            int r=row+dir[i][0];
            int c=col+dir[i][1];
            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && 
            grid[row][col]>=grid[r][c] && used[r][c]!=1){
                used[r][c]=1;
                 dfs(grid,r,c,pa,used);
            }
        }
    }
}
