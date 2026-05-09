class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            int[] arr = new int[26];
            for(int i=0;i<str.length();i++){
                arr[str.charAt(i)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<26;j++){
                sb.append(arr[j]).append("#");
            }
            String sbstr = sb.toString();
            if(!map.containsKey(sbstr)){
                 map.put(sbstr,new ArrayList());  
            }
            map.get(sbstr).add(str);
            }
        List<List<String>> result = new ArrayList<>();
        for(List<String> l : map.values()){
            result.add(l);
        } 
        return result; 
    }
}
