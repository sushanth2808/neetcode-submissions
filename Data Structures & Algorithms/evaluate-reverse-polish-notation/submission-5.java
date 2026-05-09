class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> operands = new HashSet<>();
        operands.add("*");
        operands.add("-");
        operands.add("+");
        operands.add("/");
        int val = 0;
        Stack<Integer> stack = new Stack<>();
        for(String c: tokens){
            if(!operands.contains(c)){
                stack.push(Integer.parseInt(c));
            } 
            else{
                int b = stack.pop();
                int a = stack.pop();
                if(c.equals("*")){
                    val = a*b;
                }
                if(c.equals("+")){
                    val = a+b;
                }
                if(c.equals("-")){
                    val = a-b;
                }
                if(c.equals("/")){
                    val = a/b;
                }
                stack.push(val);
            }
        }
         return stack.pop();
    }
   
}
