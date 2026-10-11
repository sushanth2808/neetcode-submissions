class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //maintain of map of s1 with the count of chars
        // loop over s2 with left pointer on 0 and right pointer moving on s2 and left moves ones s2 contain chars other than s1.
        //how do you know the condition satisfied. when everytime beffore we move left pointer need to check if s1 is completed in s2 or not.
        // what if i maintaint he counter which tells if the count in s1 satisfied current s2 state ther i can returnt true;

        Map<Character,Integer> map = new HashMap<>();
        int counter = s1.length();
        for(int i=0;i<s1.length();i++){
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }

        int left = 0;
        for(int right=0;right<s2.length();right++){
            char c = s2.charAt(right);
            if(map.containsKey(c) && map.get(c)>0){
                map.put(c,map.get(c)-1);
                counter--;
                if(counter==0){return true;}
                continue;
            }
            while(right>=left){
                char cleft = s2.charAt(left);
                if(map.containsKey(cleft)){
                    counter++;
                    map.put(cleft,map.getOrDefault(cleft,0)+1);
                }
                left++;
                if(map.containsKey(c) && map.get(c)>0){
                map.put(c,map.get(c)-1);
                counter--;
                if(counter==0){return true;}
                break;
            }
            }
        }
        return false;
    }
}
