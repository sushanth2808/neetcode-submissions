class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length()){
            return false;
        }

        int[] arr1 = new int[26];
        int[] arr2=new int[26];

        for(int i=0;i<s1.length();i++){
            arr1[s1.charAt(i)-'a']++;
            arr2[s2.charAt(i)-'a']++;
        }

        int matches=0;
        for(int i=0;i<26;i++){
            if(arr1[i]==arr2[i]){
                matches++;
            }
        }

        int left=0;
        for(int i=s1.length();i<s2.length();i++){
            if(matches==26){
                return true;
            }
            
            char c = s2.charAt(i);
            char cleft = s2.charAt(left);
            
            if(arr2[c-'a']==arr1[c-'a']){
                matches--;
            }
            arr2[c-'a']++;
            if(arr2[c-'a']==arr1[c-'a']){
                matches++;
            }

            if(arr2[cleft-'a']==arr1[cleft-'a']){
                matches--;
            }
            arr2[cleft-'a']--;
            if(arr2[cleft-'a']==arr1[cleft-'a']){
                matches++;
            }
            left++;
        }
            if(matches==26){
                return true;
            }
            return false;

    }
}
