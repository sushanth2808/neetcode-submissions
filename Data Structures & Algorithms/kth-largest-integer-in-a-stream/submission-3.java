class KthLargest {
    PriorityQueue<Integer> p ;
    int size;

    public KthLargest(int k, int[] nums) {
        p = new PriorityQueue<>();
        size = k;
        for(int i=0;i<nums.length;i++)
        {
            if(i>=k){
                if(p.peek()<nums[i]){
                    p.poll();
                    p.offer(nums[i]);
                    }    
                }
            else{
                p.offer(nums[i]);
            }
        }
        
    }
    
    public int add(int val) {
        if(!p.isEmpty() && p.size()==size){
            if(p.peek()<val){
                p.poll();
                p.offer(val);
            }
        }
        else{
            p.offer(val);
        }
        return p.peek();
        

        
    }
}
