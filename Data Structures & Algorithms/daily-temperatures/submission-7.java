class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        int index=0;
        result[n-1]=0;
        for(int i=n-2;i>=0;i--){
            int k=i+1;
            while(result[k]!=0 && temperatures[k]<=temperatures[i]){
                k=k+result[k];
            }
            
            if(temperatures[k]>temperatures[i])
            {
                result[i]=(k-i);
            }
        
        }
        return result;
       
    }
}

