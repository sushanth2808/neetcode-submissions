class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] interval = intervals[i];
            if(res.get(res.size()-1)[1]>=interval[0]){
                int[] inter = res.remove(res.size()-1);
                res.add(new int[]{inter[0],Math.max(inter[1],interval[1])});  
            }
            else{res.add(interval);}
        }
        int[][] r = new int[res.size()][];
        int index=0;
        for(int[] interval : res){
            r[index++]=interval;
        }
        return r;
    }
}
