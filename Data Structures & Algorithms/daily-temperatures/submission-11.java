class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] temp = temperatures;
        int n = temp.length;
        int[] res = new int[n];
        int[] dp = new int[n];
        dp[n-1]=0;
        for(int i=n-2;i>=0;i--){
            int index = i+1;
            int flag=0;
            while(temp[i]>=temp[index]){
                if(dp[index]==0){
                    dp[i]=0;
                    flag=1;
                    break;
                }
                index=index+dp[index];
            }
            if(flag==0){
                dp[i]=index-i;
                
            }
        }
        return dp;
    }
}
