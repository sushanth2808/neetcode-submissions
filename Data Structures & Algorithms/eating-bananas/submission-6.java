class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=1;
        for(int i=0;i<piles.length;i++){
            max=Math.max(max,piles[i]);
        }

        int p1=1;
        int p2=max;
        int res=0;

        while(p1<=p2){
            int mid = (p1+p2)/2;
            if(canEat(mid,piles,h)){
                res=mid;
                p2=mid-1;
            }
            else{
                p1=mid+1;
            }
        }
        return res;
    }

    private boolean canEat(int num, int[] piles, int target){
        int time=0; 
        for(int i=0;i<piles.length;i++){
            time = time+ piles[i]/num;
            if(piles[i]%num!=0){
                time+=1;
            }
        }
        if(time<=target){
            return true;
        }
        return false;
    }
}
