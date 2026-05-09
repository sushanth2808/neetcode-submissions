class Solution {
    int max = 0;
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return findseq(text1,text2,0,0,dp);
        
    }

    private int findseq(String s1,String s2, int idx1,int idx2,int[][] dp){
        if(idx1==s1.length() || idx2==s2.length()){
            return 0;
        }
        if(dp[idx1][idx2]!=-1){
            return dp[idx1][idx2];
        }
        if(s1.charAt(idx1) == s2.charAt(idx2)){
            return dp[idx1][idx2] = 1+findseq(s1,s2,idx1+1,idx2+1,dp);
        }
        return dp[idx1][idx2]=Math.max(findseq(s1,s2,idx1+1,idx2,dp),findseq(s1,s2,idx1,idx2+1,dp));


    }

}
