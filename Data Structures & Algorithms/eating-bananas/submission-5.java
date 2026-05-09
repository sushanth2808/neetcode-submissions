class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        Arrays.sort(piles);
        for(int i=1;i<=piles[n-1];i++){
            long time=0;
            for(int j=0;j<n;j++){
                time +=piles[j]/i;
                if(piles[j]%i!=0){
                    time +=1;
                }
            }
            if(time<=h){
                return i;
            } 
        }
        return piles[n-1];
    }
}
