class Solution {
    int count=0;
    public int countSubstrings(String s) {
        int n =s.length();
        int[] pointers;
        int[] maxPointer=new int[]{0,0};
        for(int i=0;i<n;i++){
            pointers = checkPalindrome(i,i,s,n);
            if(pointers[1]-pointers[0]>maxPointer[1]-maxPointer[0]){
                maxPointer=pointers;
            }
            pointers= checkPalindrome(i,i+1,s,n);
            if(pointers[1]-pointers[0]>maxPointer[1]-maxPointer[0]){
                maxPointer=pointers;
            }
        }
        return count;
    }

    private int[] checkPalindrome(int p1,int p2,String s,int n){
        while(p1>=0 && p2<n){
            if(s.charAt(p1)!=s.charAt(p2)){
                return new int[]{p1+1,p2-1};
            }
            count++;
            p1--;
            p2++;
        }
        return new int[]{p1+1,p2-1};
    }
}

