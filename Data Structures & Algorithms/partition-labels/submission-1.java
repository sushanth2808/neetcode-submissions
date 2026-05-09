class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] arr = new int[26];
        int n = s.length();
        for(int i=0;i<n;i++){
            arr[s.charAt(i)-'a']++;
        }
        List<Integer> res = new ArrayList<>();
        int i=0;
        Set<Character> set = new HashSet<>();
        while(i<n){
            arr[s.charAt(i)-'a']--;
            if( arr[s.charAt(i)-'a']>0){
                 set.add(s.charAt(i));
            }
            int j=i;
            while(set.size()>0 && j+1<n){
                j=j+1;
                char c = s.charAt(j);
                arr[c-'a']--;
                if(arr[c-'a']==0 && set.contains(c)){
                    set.remove(c);
                }else if(arr[c-'a']!=0){
                    set.add(c);
                }
            }
            res.add(j-i+1);
            i=j+1;
        }
        return res;
    } 
}
