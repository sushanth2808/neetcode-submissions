class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charArr = new int[128];
        if(s==null || s.length()==0){
            return 0;
        }
        int left=0;
        int maximum=0;
        for(int right=0;right<s.length();right++){
            char c = s.charAt(right);
            charArr[c]++;
            while(charArr[c]>1){
                charArr[s.charAt(left)]--;
                left++;
            }
           maximum =  Math.max(maximum,right-left+1);
        }
        return maximum;
    }
}
