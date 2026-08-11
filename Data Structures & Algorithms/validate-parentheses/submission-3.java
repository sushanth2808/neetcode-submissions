class Solution {
    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        for(int i = 0;i<s.length();i++){
            char par = s.charAt(i);
            if(!map.containsKey(par)){
                stack.push(par);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char poppar = stack.pop();
                if(map.get(par)!=poppar){
                    return false;
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
