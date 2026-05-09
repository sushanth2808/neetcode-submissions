class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        int index=0;
        //bruteforce
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(temperatures[j]>temperatures[i]){
                    result[index]=(j-i);
                    break;
                }
            }
            index++;
            
        }
        return result;
       
    }
}

