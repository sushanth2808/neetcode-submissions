class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n<=1){return intervals;}
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        merged.add(intervals[0]);

        for(int i=1;i<n;i++){
            int last=merged.size()-1;
            if(merged.get(last)[1]<intervals[i][0]){
                merged.add(intervals[i]);
            }
            else{
                merged.get(last)[1]=Math.max(intervals[i][1],merged.get(last)[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);

        
    }
}
