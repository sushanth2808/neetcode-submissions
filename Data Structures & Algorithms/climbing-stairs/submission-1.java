class Solution {
    public int climbStairs(int n) {
        List<Integer> ways = Arrays.asList(1,2);
        int[] dp = new int[n+1];
        return climb(n,ways,dp);
    }

    private int climb(int n, List<Integer> ways,int[] dp){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int count=0;
        for(int i=0;i<ways.size();i++){
            count = count + climb(n-ways.get(i),ways,dp);
        }
        dp[n]=count;
        return count;
    }
}
