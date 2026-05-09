class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public void islandsAndTreasure(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                boolean[][] used = new boolean[row][col];
                if(grid[i][j]!=0 && grid[i][j]!=-1){
                    bfs(grid,i,j,used);
                }
            }
        }
    }

    private void bfs(int[][] grid, int row, int col,boolean[][] used){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row,col});
        used[row][col]=true;
        q.add(new int[]{-1,-1});
        int distance=0;
        while(!q.isEmpty()){
            int[] node = q.poll();
            if(node[0]==-1 && !q.isEmpty()){
                q.add(node);
                distance+=1;
            }
            else if(grid[node[0]][node[1]]==0){
                grid[row][col]=distance;
                break;
            }
            else{
                for(int i=0;i<4;i++){
                    int newRow = node[0]+dir[i][0];
                    int newCol = node[1]+dir[i][1];
                    if(newRow>=0 && newCol>=0 && newRow<grid.length && newCol<grid[0].length && used[newRow][newCol]!=true){
                        if(grid[newRow][newCol]!=-1){
                            used[newRow][newCol]=true;
                            q.add(new int[]{newRow,newCol});
                        }
                    }  
                }
            }
        }
    }
}
