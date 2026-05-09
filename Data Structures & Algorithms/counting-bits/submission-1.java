class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i=1;i<n+1;i++){
            int j = i;
            int count =0;
            while(j!=0){
                j=j&(j-1);
                count++;
            }
            res[i]=count;
        }
        return res;
    }
}
