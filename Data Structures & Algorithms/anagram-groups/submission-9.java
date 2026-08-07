class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] arr = new int[26];
            for(int i=0;i<s.length();i++){
                arr[s.charAt(i)-'a']++;
            }
            StringBuilder str = new StringBuilder();
            for(int i=0;i<26;i++){
                str.append(arr[i]).append("#");
            }
            map.computeIfAbsent(str.toString(),k->new ArrayList<>()).add(s);
        }

        for(List<String> m : map.values()){
            res.add(m);
        }
        return res;
    }
}
