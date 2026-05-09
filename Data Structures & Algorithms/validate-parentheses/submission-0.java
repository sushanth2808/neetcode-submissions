class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==']' ||s.charAt(i)=='}' || s.charAt(i)==')'){
                if(stack.isEmpty()) return false;
                else{
                    Character c = stack.pop();
                    Character d = s.charAt(i);
                    if(c=='[' && d!=']') return false;
                    if(c=='{' && d!='}')return false;
                    if(c=='(' && d!=')') return false;
                }
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        if(!stack.isEmpty()) return false;
        else return true;
    }
}
