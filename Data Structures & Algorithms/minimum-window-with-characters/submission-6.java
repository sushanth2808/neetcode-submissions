class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        if(s.length()<t.length()){
            return "";
        }
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        
        int minLength = Integer.MAX_VALUE;
        int left=0;
        int len=0;
        String res = "";
        for(int right=0;right<s.length();right++){
            char cright = s.charAt(right); 
            if(map.containsKey(cright)){
                if(map.get(cright)>0){len++;}
                map.put(cright,map.get(cright)-1);
                char cleft = s.charAt(left);
                while(!map.containsKey(cleft) || map.get(cleft)<0){
                    if(map.containsKey(cleft)){
                        map.put(cleft,map.get(cleft)+1);
                    }
                    left++;
                    cleft=s.charAt(left);
                }
            }
            if(len==t.length()){
                if(minLength>=right-left+1){
                    minLength=right-left+1;
                    res=s.substring(left,right+1);
                }
              
            } 
        }
        System.out.println(minLength);
        return res;
    }
}
