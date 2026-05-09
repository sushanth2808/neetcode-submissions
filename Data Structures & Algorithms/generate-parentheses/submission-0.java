class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String str = "";
        generate(n,0,0,res,str);
        return res;
    }

    private void generate(int n, int open, int close,List<String> res,String str){
     if(open==n && close==n){
        res.add(str);
     }
     if(open<n){
        generate(n,open+1,close,res,str+"(");
     }
     if(open>close){
        generate(n,open,close+1,res,str+")");
     }
    }
}
