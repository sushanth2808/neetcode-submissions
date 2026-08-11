class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> p = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int i=0;i<stones.length;i++){
            p.offer(stones[i]);
        }

        while(p.size()>=2){
            int x = p.poll();
            int y = p.poll(); 
            int newStone = Math.abs(x-y);
            if(newStone!=0){p.offer(newStone);}
        }
        if(p.isEmpty()){return 0;}
        return p.peek();
        
    }
}
