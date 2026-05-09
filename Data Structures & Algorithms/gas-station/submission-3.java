class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int curr =0;
        int start=-1;
        int end =n;

        for(int i=0;i<n;i++){
            curr = curr+gas[i]-cost[i];
            if(curr>=0){start=i;}
            int index = i+1;
            while(curr>=0){
                if(index>=n){index=0;}
                if(index==start){
                    return start;
                }
                curr=curr+gas[index]-cost[index];
                index++;
                end=index;
            }
            curr=0;
            start=-1;
            if(end<i){return start;}
        }
        return start;
    }
}
