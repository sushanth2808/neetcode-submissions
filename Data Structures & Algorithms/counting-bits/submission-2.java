class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        int power = 1;
        for(int i=1;i<n+1;i++){
            if((i&(i-1))==0){
                power=i;
                res[i]=1;
            }
            else{
                res[i]=res[power]+res[i%power];
            }
            
        }
        return res;
    }
}
