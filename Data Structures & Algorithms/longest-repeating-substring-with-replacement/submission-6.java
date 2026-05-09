class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] arr  = new int[26];
        int maxLength=0;
        int maxf = 0;
        int l=0;
        int r=0; 
        while(r<n){
            arr[s.charAt(r)-'A']++;
            maxf=Math.max(maxf,arr[s.charAt(r)-'A']);
            while(r-l+1-maxf>k){
                arr[s.charAt(l)-'A']--;
                maxf=Math.max(arr[s.charAt(l)-'A'],maxf);
                l++;
            }
            maxLength = Math.max(r-l+1,maxLength);
            r++;
        }
        return maxLength;
    }
}
