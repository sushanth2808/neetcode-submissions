class Solution {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
         for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
         }
         return bfs(grid,fresh,q,0);
    }

    private int bfs(int[][] grid, int fresh, Queue<int[]> q,int minutes){
        while(!q.isEmpty() & fresh>0){
            int size = q.size();

            for(int i=0;i<size;i++){
                int[] cell = q.poll();
                for(int[] dir : directions){
                    int nr = cell[0]+dir[0];
                    int nc = cell[1]+dir[1];
                    if(nc<grid[0].length && nc>=0 && nr<grid.length &&  nr>=0 && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        fresh--;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
            minutes++;
        }
        return fresh==0?minutes:-1;
    }
}
