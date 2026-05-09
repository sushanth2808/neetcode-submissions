class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n =s.length();
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int count=0;
                Set<Character> set = new HashSet<>();
                for(int k=i;k<=j;k++){
                   if(set.contains(s.charAt(k))){
                    break;
                   }
                   else{
                    set.add(s.charAt(k));
                    count++;
                   }
                }
                res=Math.max(res,count);
            }
        }
        return res;
    }
}
