class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int p1=0;
        int p2=n-1;
        boolean deleted = false;
        boolean res1 = true;
        boolean res2=true;
        while(p1<p2){
            if(s.charAt(p1)==s.charAt(p2)){
                p1++;
                p2--;
            }
            else{
                if(deleted){
                res1=false; 
                break;
                }
                deleted=true;
                p1++;
            }
        }

        deleted=false;
        p1=0;
        p2=n-1;

        while(p1<p2){
            if(s.charAt(p1)==s.charAt(p2)){
                p1++;
                p2--;
            }
            else{
                if(deleted){
                    res2=false; 
                    break;
                }
                deleted=true;
                p2--;
            }
        }
        return res1 || res2;
        
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