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

    private void findIsland(char[][] grid, int row,int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row,col});
        grid[row][col]='0';
        while(!q.isEmpty()){
            int[] cell = q.poll();
            for(int i=0;i<4;i++){
                row=cell[0]+dir[i][0];
                col=cell[1]+dir[i][1];
                if(row>=0 && col>=0 && row<grid.length && col<grid[0].length && grid[row][col]!='0'){
                    grid[row][col]='0';
                    q.add(new int[]{row,col});
                }
            }
        }
    }
}
