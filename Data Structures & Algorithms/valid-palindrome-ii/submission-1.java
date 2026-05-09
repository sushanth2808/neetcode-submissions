class Solution {
    public boolean validPalindrome(String s) {

        return valid(s,0,s.length()-1,0);
    }

    private boolean valid(String s, int l, int r,int count){
        if(l>=r){
            return true;
        }
        if(s.charAt(l)==s.charAt(r)){
            return valid(s,l+1,r-1,count);
        }
        else{
            if(count==1){
                return false;
            }
            return valid(s,l,r-1,count+1) || valid(s,l+1,r,count+1);
        }
    }
}