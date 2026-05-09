class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()){
            return false;
        }

       int[] arr = new int[26];
        for(int i=0;i<s1.length();i++){
            arr[s1.charAt(i)-'a']++;  
        }
        int left=0;
        for(int right=0;right<s2.length();right++){
            int idx=s2.charAt(right)-'a';
            arr[idx]--;
            while(arr[idx]<0){
                arr[s2.charAt(left)-'a']++;
                left++;
            }
            if(right-left+1==s1.length()){
                return true;
            }
        }
        return false;
    }
}
