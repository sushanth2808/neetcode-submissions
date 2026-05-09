class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s2.length();
        int[] arr = new int[26];
        for(int i=0;i<s1.length();i++){
            arr[s1.charAt(i)-'a']++;
        }
        int p1=0;
        int p2=0;
        while(p2<n){
            arr[s2.charAt(p2)-'a']--;
            while(arr[s2.charAt(p2)-'a']<0){
                arr[s2.charAt(p1)-'a']++;
                p1++;
            }
            if(p2-p1+1==s1.length()){
                return true;
            }
            p2++;
        }
        return false;

    }
}
