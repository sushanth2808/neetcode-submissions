class Solution {
    public int lengthOfLongestSubstring(String s) {
         Set<Character> set = new HashSet<>();
         int n = s.length();
         int maxLength = 0;
         int start =0;
         for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
            }
            else{
                if((i-start)>maxLength){
                    maxLength=i-start;
                }
                while(start<i && set.contains(c)){
                    set.remove(s.charAt(start));
                    start++;
                }
                set.add(c);
            }
         }
         if((n-start)>maxLength){
            return n-start;
         }
         return maxLength;
    }     
}
