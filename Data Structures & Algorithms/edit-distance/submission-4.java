class Solution {
    public int minDistance(String word1, String word2) {

        //replace - move both
        //delete  - move word1
        //replace - move word2
        int n=word1.length();
        int m= word2.length();
        int[][] dp = new int[n+1][m+1];
        dp[n][m]=0;
        for(int i=m-1;i>=0;i--){
            dp[n][i]=dp[n][i+1]+1;
        }
        for(int i=n-1;i>=0;i--){
            dp[i][m]=dp[i+1][m]+1;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(word1.charAt(i)!=word2.charAt(j)){
                    dp[i][j]=1+minimum(dp[i+1][j],dp[i+1][j+1],dp[i][j+1]);
                }
                else{
                    dp[i][j]=dp[i+1][j+1];
                }
            }
        }
        return dp[0][0]; 
    }


    private int minimum(int count1, int count2, int count3){
        int min = Math.min(count1,count2);
        return Math.min(min,count3);
    }
}
