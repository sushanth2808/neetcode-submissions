class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] arr = new int[26];
            for(int i=0;i<str.length();i++){
                arr[str.charAt(i)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                sb.append(arr[i]).append('#');
            }
            String key = sb.toString();
            map.computeIfAbsent(key,k->new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
