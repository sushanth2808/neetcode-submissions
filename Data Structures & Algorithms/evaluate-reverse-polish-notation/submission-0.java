class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> operands = new HashSet<>();
        operands.add("*");
        operands.add("-");
        operands.add("+");
        operands.add("/");
        int result=0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String c = tokens[i];
            if(operands.contains(c)){
                System.out.println(c);
                int a = stack.pop();
                int b = stack.pop();
                switch(c){
                    case "+": {result = a+b; break;}
                    case "-": {result = b-a; break;}
                    case "*": {result = a*b; break;}
                    case "/": {result = b/a; break;}
                } 
                stack.push(result);
            }
            else{
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop(); 
    }
}
