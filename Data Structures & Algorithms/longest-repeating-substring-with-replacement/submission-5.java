class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLength=0;
        for(int i=0;i<n;i++){
            int changingk = k;
            int l = 0;
            int maxf=0;
            int[] arr = new int[26];
            for(int j=i;j<n;j++){
                arr[s.charAt(j)-'A']++;
                maxf = Math.max(maxf,arr[s.charAt(j)-'A']);
                if(maxf+k>=j-i+1){
                    maxLength=Math.max(maxLength,j-i+1);
                }
                else{
                    break;
                }
            }
        }
        return maxLength;
    }
}
