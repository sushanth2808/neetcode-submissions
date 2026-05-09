class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> p = new PriorityQueue<>((a, b) -> b[0]-a[0]);
        for(int[] point : points){
            int dist = point[0] * point[0] + point[1] * point[1];            int[] arr = new int[3];
            arr[0]=dist;
            arr[1]=point[0];
            arr[2]=point[1];
            p.offer(arr);
            if(p.size()>k){
                p.poll();
            }
        }
        int[][] res = new int[k][2];
        int idx =0;
        while(!p.isEmpty()){
            int[] polledVal = p.poll();
            res[idx][0]=polledVal[1];
            res[idx][1]=polledVal[2];
            idx++;
        }
        return res;
    }

}


