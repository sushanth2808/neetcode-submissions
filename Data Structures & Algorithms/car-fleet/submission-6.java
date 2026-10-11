class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] fleet = new double[n][2];
        for(int i=0;i<n;i++){
            fleet[i]=new double[]{position[i],(double)(target-position[i])/speed[i]};
        }
        Arrays.sort(fleet,(a,b)->Double.compare(b[0],a[0]));
        int count = 1;
        double initial = fleet[0][1];
        for(int i=1;i<n;i++){
            if(fleet[i][1]>initial){
                initial = fleet[i][1];
                count++;
            }
        }
        return count;
    }
}
