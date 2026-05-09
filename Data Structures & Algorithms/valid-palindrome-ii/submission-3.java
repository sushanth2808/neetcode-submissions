class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int p1=0;
        int p2=n-1;
        return valid(s,p1,p2,false,"left") || valid(s,p1,p2,false,"right");
    
    }

    private boolean valid(String s, int p1,int p2, boolean deleted,String side){
         while(p1<p2){
            if(s.charAt(p1)==s.charAt(p2)){
                p1++;
                p2--;
            }
            else{
                if(deleted){return false;}
                deleted=true;
                if(side.equals("left")){
                    p1++;
                }
                else{
                    p2--;
                }
            }
        }
        return true;
    }
}