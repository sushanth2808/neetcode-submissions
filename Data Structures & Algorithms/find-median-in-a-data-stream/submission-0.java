class MedianFinder {
    List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
        list.sort(Comparator.naturalOrder());
    }
    
    public double findMedian() {
        if(list.size()%2!=0){
            int medianIndex = list.size()/2;
            return list.get(medianIndex);
        }
        else{
            int medianIndex = list.size()/2;
            double median = (list.get(medianIndex)+list.get(medianIndex-1))/2.0;
            return median;
        }
    }
}
