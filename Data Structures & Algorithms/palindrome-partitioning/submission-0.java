class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        int n = s.length();
        findPart(s,0,n);
        return res;
    }

    private void findPart(String s,int start,int end){
        if(start==end){
            res.add(new ArrayList<>(list));
        }

        for(int i=start;i<end;i++){
            String p = s.substring(start,i+1);
            if(isPalindrome(p)){
                list.add(p);
                findPart(s,i+1,end);
                list.remove(p);
            }
        }
    }

    private boolean isPalindrome(String s){
        int p1=0;
        int p2=s.length()-1;
        while(p1<=p2){
            if(s.charAt(p1)!=s.charAt(p2)){
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}
