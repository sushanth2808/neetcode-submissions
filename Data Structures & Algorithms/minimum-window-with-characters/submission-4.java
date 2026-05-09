class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }

        int count=0;
        int left=0;
        int min=s.length();
        int minIndex=-1;
        int maxIndex=-1;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i))>0){
                count++;
            }
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)-1);
            while(count==t.length()){
            
                if(i-left+1<=min){
                    min=i-left+1;
                    minIndex=left;
                    maxIndex=i;
                }
                map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)+1);

                if(map.containsKey(s.charAt(left)) && map.get(s.charAt(left))>0){
                    count--;
                }
                left++;
            }
        }
        System.out.println(minIndex+" "+maxIndex);
        if(minIndex==-1 || maxIndex==-1){
            return "";
        }
        return s.substring(minIndex,maxIndex+1);
    }
}
