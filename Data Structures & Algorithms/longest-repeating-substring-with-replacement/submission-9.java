class Solution {
    public int characterReplacement(String s, int k) {
        int n =s.length();
        int res=0;
        int[] arr = new int[26];
        int left=0;
        int max = 0;
        for(int i=0;i<n;i++){
            arr[s.charAt(i)-'A']++;
            max=Math.max(max,arr[s.charAt(i)-'A']);
            while((i-left+1)-max>k){
                arr[s.charAt(left)-'A']--;
                left++;
            }
            res = Math.max(res,i-left+1);
        }
        return res;
    }
}
