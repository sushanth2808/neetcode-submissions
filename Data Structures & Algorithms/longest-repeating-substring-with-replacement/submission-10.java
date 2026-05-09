class Solution {
    public int characterReplacement(String s, int k) {
        int n =s.length();
        int[] arr = new int[26];
        int p1=0;
        int p2=0;
        char maxChar=s.charAt(0);
        int count=0;
        int max=0;
        while(p2<n){
            arr[s.charAt(p2)-'A']++;
            if(arr[s.charAt(p2)-'A']>=arr[maxChar-'A']){
                maxChar=s.charAt(p2);
            }
            if(p2-p1+1-(arr[maxChar-'A'])<=k){
                p2++;
            }
            else{
                p2++;
                arr[s.charAt(p1)-'A']--;
                p1++;
            }
            max=p2-p1;
        }
        return max;
    }
}
