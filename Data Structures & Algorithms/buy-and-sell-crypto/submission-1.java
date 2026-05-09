public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int max=0;
        for(int i=1;i<n;i++){
            if(prices[i]-min>max){
                max=prices[i]-min;
            }
            if(prices[i]<min){
                min=prices[i];
            }
        }
        return max;
    }
}