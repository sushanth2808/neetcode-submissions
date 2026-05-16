class Solution {
    String word1,word2;
    int min = Integer.MAX_VALUE;
    public int minDistance(String word1, String word2) {

        //replace and move forward - move both
        //delete and move forward  - move word1
        //replace and stay there   - move word2

        int[][] dp = new int[word1.length()][word2.length()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        this.word1=word1;
        this.word2=word2;
        return distance(0,0,dp);
       
    }

    private int distance(int i, int j,int[][] dp){
        if(j==word2.length()){
           return word1.length()-i;
        }
        if(i==word1.length()){
          return word2.length()-j;
        }
        if(dp[i][j]!=-1)return dp[i][j];

        if(word1.charAt(i)!=word2.charAt(j)){
            return dp[i][j] = 1+minimum(distance(i+1,j+1,dp),distance(i+1,j,dp),distance(i,j+1,dp));
        }
        else{
            return dp[i][j]=distance(i+1,j+1,dp);
        } 
    }  

    private int minimum(int count1, int count2, int count3){
        int min = Math.min(count1,count2);
        return Math.min(min,count3);
    }
}
