class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder alphanumeric = new StringBuilder();
        for(int i=0;i<s.length();i++){
             if(isAlphanumeric(s.charAt(i))){

                alphanumeric.append(s.charAt(i));
             }
        }
        String al = alphanumeric.toString();
        String aln = al.toLowerCase();
        System.out.println(aln);
        int first =0;
        int last = aln.length()-1;
        while(first<=last){          
            if(aln.charAt(first)!=aln.charAt(last)){
                return false;
            }
            first++;
            last--;
        }
  return true;
        }  
    private boolean isAlphanumeric(char c){
        return (c >= 'A' && c <= 'Z') || 
           (c >= 'a' && c <= 'z') || 
           (c >= '0' && c <= '9');
    }
}

