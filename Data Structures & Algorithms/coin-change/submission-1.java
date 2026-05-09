class Solution {
    int minCount =Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        find(coins,amount,0,0);
        if(minCount==Integer.MAX_VALUE){
            return -1;
        }
        return minCount;
    }

    private void find(int[] coins, int amount, int index,int count){
        if(amount==0){
             minCount = Math.min(minCount,count);
        }
        if(amount<0){
            return;
        }
        for(int i=index;i<coins.length;i++){
          find(coins,amount-coins[i],i,count+1);
        }
    }
}
