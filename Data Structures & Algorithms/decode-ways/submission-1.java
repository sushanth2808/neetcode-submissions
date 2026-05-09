class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return decode(s,0,n,dp);
    }

    private int decode(String s, int i, int n,int[] dp){
        if(i==n) return 1;
        if(s.charAt(i)=='0'){
            return 0;
        }
        if(dp[i]!=-1)return dp[i];
        int ways = decode(s,i+1,n,dp);
        if(i+1<n){
            int num = Integer.parseInt(s.substring(i,i+2));
            if(num>=10 && num<=26){
                ways+=decode(s,i+2,n,dp);
            }
        }
        return dp[i]=ways;
    }
}
