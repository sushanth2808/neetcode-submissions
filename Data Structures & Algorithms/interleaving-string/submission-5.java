public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        int len1=s1.length();
        int len2=s2.length();
        if(s3.length()!=len1+len2){
            return false;
        }
        dp[len1][len2]=true;
        int k=len1+len2;
        for(int i=len2-1;i>=0;i--){
            if(s3.charAt(i+len1)==s2.charAt(i)){
                dp[len1][i]=dp[len1][i+1];
            }
        }
        for(int i=len1-1;i>=0;i--){
            if(s3.charAt(i+len2)==s1.charAt(i)){
                dp[i][len2]=dp[i+1][len2];
            }
        }

        for(int i=len1-1;i>=0;i--){
            for(int j=len2-1;j>=0;j--){
                boolean res = false;
                if(s1.charAt(i)==s3.charAt(i+j)){
                    res=dp[i+1][j];
                }
                if(!res && s2.charAt(j)==s3.charAt(i+j)){
                    res=dp[i][j+1];
                }
                dp[i][j]=res;
            }
        }
        return dp[0][0];
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