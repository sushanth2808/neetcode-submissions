class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        char[] carr = s.toCharArray();

        int left=0;
        int maxlength=0;
        int maxf=0;
        for(int right=0;right<carr.length;right++){
            int index = carr[right]-'A';
            arr[index]++;
            if(arr[index]>maxf){
                maxf=arr[index];
            }
            int len = right-left+1;
            while(len-maxf>k){
                arr[carr[left]-'A']--;
                left++;
                len=right-left+1;
            }
            maxlength=Math.max(maxlength,right-left+1);
        }
        return maxlength;
    }
}
