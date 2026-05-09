class Solution {
    public List<List<String>> groupAnagrams(String[] strs) { 
        Map<String,List<String>> map = new HashMap<>(); 
        for(String s:strs){
            int[] count = new int[26];
            for(int i=0;i<s.length();i++){
                count[s.charAt(i)-'a']++;
            }
            StringBuilder keyBuilder = new StringBuilder();
            for(int i=0;i<26;i++){
                keyBuilder.append("#");
                keyBuilder.append(count[i]);
            }
            String key = keyBuilder.toString();
            map.computeIfAbsent(key,k->new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());

    }
}
