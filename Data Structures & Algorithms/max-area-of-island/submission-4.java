class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int maxi = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]!=0){
                    int area = bfs(grid,i,j);
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

    private int bfs(int[][] grid, int row,int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row,col});
        grid[row][col]=0;
        int count = 1;
        while(!q.isEmpty()){
            int[] cell = q.poll();
            for(int i=0;i<4;i++){
                row=cell[0]+dir[i][0];
                col=cell[1]+dir[i][1];
                if(row>=0 && col>=0 && row<grid.length && col<grid[0].length && grid[row][col]!=0){
                    grid[row][col]=0;
                    q.add(new int[]{row,col});
                    count++;
                }
            }
        }
        return count;
    }
}
