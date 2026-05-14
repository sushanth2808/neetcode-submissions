class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }

        for(int i=0;i<words.length-1;i++){
            String word1 = words[i];
            String word2 = words[i+1];
            int len = Math.min(word1.length(),word2.length());
            boolean diff=false;
            for(int j=0;j<len;j++){
                int rank1=map.get(word1.charAt(j));
                int rank2 = map.get(word2.charAt(j));
                if(rank1>rank2){
                    return false;
                }
                if(rank1<rank2){
                    diff=true;
                    break;
                }
            }
            if(!diff && word1.length()>word2.length()){
                return false;
            }
        }
        return true;
    }
}