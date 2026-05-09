class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
           if(map.containsKey(c)){
            if(!stack.isEmpty() && stack.peek()==map.get(c)){
                stack.pop();
            }
             else{ return false;}
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        if(!stack.isEmpty()) return false;
        else return true;
    }
}
