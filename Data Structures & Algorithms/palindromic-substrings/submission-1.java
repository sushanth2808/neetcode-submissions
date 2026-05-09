class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int start = 0, maxLen = 1;

        // base: single chars
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }

        // check substrings of length >= 2
        for(int len = 2; len <= n; len++){
            for(int i = 0; i <= n - len; i++){
                int j = i + len - 1;

                if(s.charAt(i) == s.charAt(j)){
                    if(len == 2 || dp[i+1][j-1]){
                        dp[i][j] = true;

                        if(len > maxLen){
                            maxLen = len;
                            start = i;
                        }
                    }
                }
            }
        }
        int count =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
}
