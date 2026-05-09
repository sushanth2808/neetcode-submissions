class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] arr= new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']=i;
        }

        int start=0;
        int end=0;
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            end=Math.max(end,arr[s.charAt(i)-'a']);

           if(i==end){
            res.add(end-start+1);
            start=i+1;
           }
        }
        return res;
    }
}
