class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> p = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<stones.length;i++){
            p.add(stones[i]);
        }
        while(p.size()>1){
            int x = p.poll();
            int y = p.poll();
            if(x!=y){
                p.add(x-y);
            }
        }
        if(p.size()==1){
            return p.poll();
        }
        return 0;
    }
}
