class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for(String str: strs){
            int n = str.length();
            builder.append(n).append("#").append(str);
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
            int index=0;

            while(index<str.length()){
            int j = index;
        while (str.charAt(j) != '#') {
            j++;
        }
        int length = Integer.parseInt(str.substring(index, j));
        
        // Move past '#'
        j++;
        
        list.add(str.substring(j,j+length));
            index=j+length;
            }
            return list;
        }
}
