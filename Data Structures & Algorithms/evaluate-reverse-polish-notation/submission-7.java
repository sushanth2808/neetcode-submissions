class Solution {
    public int evalRPN(String[] tokens) {
        List<String> list = new ArrayList<>(Arrays.asList(tokens));
        return dfs(list);
    }

    private int dfs(List<String> tokens){
        
        String token = tokens.remove(tokens.size()-1);


        if("+-*/".contains(token)){
            int a = dfs(tokens);
            int b =dfs(tokens);

            switch(token){
                case "+": return b+a;
                case "-": return b-a;
                case "*":   return b*a;
                case "/":   return b/a;
            }
            return -1;
        }
        
        else{
            return Integer.parseInt(token);
        }
      

    }
   
}
