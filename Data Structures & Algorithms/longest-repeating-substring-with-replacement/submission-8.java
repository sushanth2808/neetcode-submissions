class Solution {
    public int characterReplacement(String s, int k) {
        int n =s.length();
        int res=0;
        for(int i=0;i<n;i++){
            int max=0;
            int[] arr = new int[26];
            for(int j=i;j<n;j++){
                arr[s.charAt(j)-'A']++;
                max = Math.max(max,arr[s.charAt(j)-'A']);
                if((j-i+1)-max<=k){
                res=Math.max(res,j-i+1);
            }  
            }
        }
        return res;
    }
}
