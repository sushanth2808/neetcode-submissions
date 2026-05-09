class MedianFinder {
    PriorityQueue<Integer> first;
    PriorityQueue<Integer> second;
    public MedianFinder() {
        first = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        second = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
            if(first.isEmpty() || first.peek()>=num){
                first.add(num);
                System.out.println("firstloop:"+num);
            }
            else{
                second.add(num);
                System.out.println("secondloop:"+num);

            }

            if(first.size()<=second.size()-1){
                first.add(second.poll());

            }
            else if(first.size()-1>second.size()){
                second.add(first.poll());
            }
            System.out.println("first:"+first.peek());
            if(!second.isEmpty()){
                 System.out.println("second:"+second.peek());
            }
           

    }
    
    public double findMedian() {
        if(first.size()==second.size()){
            return (first.peek()+second.peek())/2.0;
        }
        else{
            return first.peek();
        }
    }
}
