class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLength=0;
        for(int i=0;i<n;i++){
            int maxf=0;
            int[] arr = new int[26];
            for(int j=i;j<n;j++){
                arr[s.charAt(j)-'A']++;
                maxf = Math.max(maxf,arr[s.charAt(j)-'A']);
                int changesRequired = j-i+1-maxf;
                if(changesRequired>k){
                    break;
                }
                else{
                    maxLength= Math.max(maxLength,j-i+1);
                }
            }
        }
        return maxLength;
    }
}
