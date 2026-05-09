
class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    int inf = 2147483647;
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshFruits = 0;
        for(int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                boolean[][] used = new boolean[row][col];
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    freshFruits+=1;
                }
            }
        }
        if(freshFruits==0){
            return 0;
        }
        return bfs(grid,q,freshFruits);
    }

    private int bfs(int[][] grid,Queue<int[]> q,int fresh){
        int time =0;
        while(!q.isEmpty()) {
            int flag=1;
            int size=q.size();
            for(int j=0;j<size;j++){
            int[] node = q.poll();
            int r   = node[0];
            int c = node[1];
            for(int i=0;i<4;i++){
                int newRow = node[0]+dir[i][0];
                int newCol = node[1]+dir[i][1];
                if(newRow>=0 && newCol>=0 && newRow<grid.length && newCol<grid[0].length && grid[newRow][newCol]==1){
                    flag=0;
                    grid[newRow][newCol]=2;
                    q.add(new int[]{newRow,newCol});
                    fresh--;
                }
            }
        }
        if(flag==0){
            time+=1;
        }
        }
        if(fresh==0){
            return time;
        }
        else{return -1;}
    }
}

