class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(piles[i],max);
        }

        int p1=1;
        int p2=max;

        int minimumTime = 0;
        while(p1<=p2){
            int mid=p1+(p2-p1)/2;
            if(condition(mid,piles,h)){
                minimumTime=mid;
                p2=mid-1;
            }
            else{
                p1=mid+1;
            }
        }
        return minimumTime;
    }

    private boolean condition(int mid, int[] piles,int hours){
        long time =0;
        for(int i=0;i<piles.length;i++){
            time = time+piles[i]/mid;
            if(piles[i]%mid!=0){
                time+=1;
            }
        }
        if(time<=hours){
            return true;
        }
        return false;
    }
}
