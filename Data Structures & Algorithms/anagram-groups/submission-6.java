class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int m = strs.length;
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<m;i++){
            int[] key = new int[26]; 
            String str = strs[i];
            for(int j=0;j<str.length();j++){
                key[str.charAt(j)-'a']++;
            }
            StringBuilder strbuilder = new StringBuilder();
            for(int k=0;k<26;k++){
                strbuilder.append("#");
                strbuilder.append(key[k]);
            }
            String s = strbuilder.toString();
            List<String> list = map.getOrDefault(s,new ArrayList<>());
            list.add(str);
            map.put(s,list);
        }
        System.out.println(map.values());
        List<List<String>> result = new ArrayList<>();
        for(List<String> l : map.values()){
            result.add(l);
        }  
        return result;
    }
}
