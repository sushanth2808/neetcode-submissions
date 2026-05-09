class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Stack<Double> stack = new Stack<>();
        int[][] spd = new int[n][2];
        for(int i=0;i<n;i++){
            spd[i][0]=position[i];
            spd[i][1]=speed[i];
        }
        Arrays.sort(spd,(a,b)->Integer.compare(b[0],a[0]));

        for(int i=0;i<n;i++){
            double time = (double) (target-spd[i][0])/spd[i][1];
            double merge = time;
          if(!stack.isEmpty() && stack.peek()>=time){
             merge = stack.pop();
          }  
          stack.push(merge);
        }

        return stack.size();
    }
}
