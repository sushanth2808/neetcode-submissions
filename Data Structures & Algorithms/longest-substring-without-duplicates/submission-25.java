class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n =s.length();
        int res=0;
        int start=0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(s.charAt(i))){
                start=Math.max(start,map.get(s.charAt(i))+1);
                
            }
            map.put(s.charAt(i),i);
            res=Math.max(res,i-start+1);
        }
        return res;
    }
}
