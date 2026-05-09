class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        Boolean[] dp = new Boolean[n];
        for(int i=0;i<wordDict.size();i++){
            set.add(wordDict.get(i));
        }
        return find(s,set,0,dp);

    }

    private boolean find(String s, Set<String> set, int start,Boolean[] dp){
        if(start==s.length()){
            return true;
        }
        if(dp[start]!=null){return dp[start];}
        for(int i=start;i<s.length();i++){
            if(set.contains(s.substring(start,i+1))){
                if(find(s,set,i+1,dp)){
                    return true;
                }
            }
        }
        return dp[start]=false;
    }
}
