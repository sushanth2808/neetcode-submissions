class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map1 = new HashMap<>();
        for(int i=0;i<t.length();i++){
            map1.put(t.charAt(i),map1.getOrDefault(t.charAt(i),0)+1);
        }
        int min =Integer.MAX_VALUE;;
        String str="";
        for(int i =0;i<s.length();i++){
            int count=0;
            Map<Character,Integer> map = new HashMap<>(map1);
            for(int j=i;j<s.length();j++){
                if(map.containsKey(s.charAt(j)) && map.get(s.charAt(j))!=0){
                    map.put(s.charAt(j),map.get(s.charAt(j))-1);
                    count++;
                }
                if(count==t.length()){
                    if(j-i+1<min){
                        min=j-i+1;
                        str=s.substring(i,j+1);
                    }
                }
            }
        }
        return str;
    }
}
