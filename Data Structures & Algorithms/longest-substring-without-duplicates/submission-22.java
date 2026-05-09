class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n =s.length();
        int res=0;
        int start=0;
        int flag=0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            flag=0;
            if(map.containsKey(s.charAt(i))){
                flag=1;
                res=Math.max(res,i-start);
                start=Math.max(start,map.get(s.charAt(i))+1);
                
            }
            map.put(s.charAt(i),i);
        }
        if(flag==0){
            res=Math.max(res,n-start);
        }
        return res;
    }
}
