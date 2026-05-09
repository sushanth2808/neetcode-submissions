class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    int inf = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                boolean[][] used = new boolean[row][col];
                if(grid[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        }
        bfs(grid,q);
    }

    private void bfs(int[][] grid,Queue<int[]> q ){
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int r   = node[0];
            int c = node[1];
            for(int i=0;i<4;i++){
                int newRow = node[0]+dir[i][0];
                int newCol = node[1]+dir[i][1];
                if(newRow>=0 && newCol>=0 && newRow<grid.length && newCol<grid[0].length && grid[newRow][newCol]==inf){
                    grid[newRow][newCol]=grid[r][c]+1;
                    q.add(new int[]{newRow,newCol});
                }
            }
        }
    }
}
