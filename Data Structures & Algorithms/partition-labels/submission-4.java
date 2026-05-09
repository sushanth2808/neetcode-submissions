class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] arr= new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']=i;
        }

        int i=0;
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        while(i<n){
            int move=arr[s.charAt(i)-'a'];
            int j=i+1;
            while(j<=move){
                move=Math.max(move,arr[s.charAt(j)-'a']);
                j++;
            }
            res.add(j-i);  
            i=j;
        }
        return res;
    }
}
