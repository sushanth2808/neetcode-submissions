class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max =0;
        for(int i=0;i<piles.length;i++){
            max = Math.max(max,piles[i]);
        }

        int p1=0;
        int p2=max;
        int ans=max;

        while(p1<=p2){
            int mid = p1+((p2-p1)/2);
            if(isValid(mid,piles,h)){
                ans = mid;
                p2=mid-1;
            }
            else{
                p1=mid+1;
            }
        }
        return ans;
    }

    private boolean isValid(int target, int[] piles, int hour){
        int time = 0;
        if(target==0){return false;}
        for(int i=0;i<piles.length;i++){
            time+=piles[i]/target;
            if(piles[i]%target!=0){
                time+=1;
            }
            if(time>hour){
                return false;
            }
        }
        return true;
    }
}
