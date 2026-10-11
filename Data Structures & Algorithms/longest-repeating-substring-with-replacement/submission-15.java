class Solution {
    public int characterReplacement(String s, int k) {
        
        //start move then check if non most repeating character count should be less than or equal to k.
        //if greater then move the left pointer till condition satisfied.
        //when moving forward we can check if count > max then know the maximum repeating character
        //how do you know when moving left pointer what is maximum repeating character count in the window
        int[] arr = new int[26];
        int left = 0;
        int maxCount = 0;
        int res = 0;
        for(int right=0;right<s.length();right++){
            arr[s.charAt(right)-'A']++;
            maxCount = Math.max(maxCount,arr[s.charAt(right)-'A']);
            while(right-left+1-maxCount>k){
                arr[s.charAt(left)-'A']--;
                left++;
            }
            res = Math.max(res,right-left+1);
        }
        return res;
    }
}
