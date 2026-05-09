class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int index=0;
        for(int query: queries){
            int min=Integer.MAX_VALUE;
            for(int[] interval : intervals){
                if(query>=interval[0] &&  query<=interval[1]){
                    min=Math.min(min,interval[1]-interval[0]+1);
                }
            }
            queries[index++]= min==Integer.MAX_VALUE?-1:min;
        }
        return queries;
    }
}
