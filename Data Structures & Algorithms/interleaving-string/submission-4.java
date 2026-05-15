public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        
        return dfs(0, 0, 0, s1, s2, s3,dp);
    }

    private boolean dfs(int i, int j, int k, String s1, String s2, String s3,Boolean[][] dp) {
        if (k == s3.length()) {
            return (i == s1.length()) && (j == s2.length());
        }
        if(dp[i][j]!=null){return dp[i][j];}

        boolean res=false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
          res = dfs(i + 1, j, k + 1, s1, s2, s3,dp);    
        }
        if (!res && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
           res= dfs(i, j + 1, k + 1, s1, s2, s3,dp);
        }
        return dp[i][j]=res;
    }
}