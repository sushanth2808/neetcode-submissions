class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int left=0;
        int n = s.length();
        int res=0;
        if(n==0 || n==1){
            return n;
        }
        map.put(s.charAt(0),0);
        for(int i=1;i<n;i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i))+1);
                map.put(s.charAt(i),i);
                res = Math.max(res,i-left+1);
            }
            else{
                res = Math.max(res,i-left+1);
                map.put(s.charAt(i),i);
            }
        }
        return res;
    }
}
