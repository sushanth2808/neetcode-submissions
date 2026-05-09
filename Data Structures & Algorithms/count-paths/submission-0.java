class Solution {
    int[][] dir = {{0,1},{1,0}};
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return findPaths(m,n,0,0,dp);
    }

    private int findPaths(int m, int n,int row, int col,int[][] dp){
        if(row==m-1 && col==n-1){
            return 1;
        }
        if(dp[row][col]!=-1){return dp[row][col];}
        int res =0;
        for(int i=0;i<2;i++){
            int r = row+dir[i][0];
            int c = col+dir[i][1];
            if(r<m && c<n && r>=0 && c>=0){
                res=res+findPaths(m,n,r,c,dp);
            }
        }
        return dp[row][col]=res;
    }
}
