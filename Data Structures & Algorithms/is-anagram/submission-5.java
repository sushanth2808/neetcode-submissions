class Solution {
    public boolean isAnagram(String s, String t) {
        int[] anagram = new int[26];
        if(s.length()!=t.length()){
            return false;
        }
        int n = s.length();
        for(int i =0;i<n;i++){
            anagram[s.charAt(i)-'a']++;
            anagram[t.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(anagram[i]!=0){
                return false;
            }
        }
        return true;
}
}
