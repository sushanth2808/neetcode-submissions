class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int i=0;i<piles.length;i++){
            max = Math.max(piles[i],max);
        }

        int p1 = 1;
        int p2 = max;
        int res = max;
        while(p1<=p2){
            int mid = p1+(p2-p1)/2;
            if(kokoCanEat(mid,piles,h)){
                res=mid;
                p2=mid-1;
            }
            else{
                p1=mid+1;
            }
        }
        return res;
    }

    private boolean kokoCanEat(int target,int[] piles, int h){
        int count = 0;
        for(int i=0;i<piles.length;i++){
            if(piles[i]%target==0){
                count+=piles[i]/target;
            }
            else{
                count+=piles[i]/target+1;
            }
            if(count>h){
                return false;
            }
        }
        return count<=h;
    }
}
