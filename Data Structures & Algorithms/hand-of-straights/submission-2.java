class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        Arrays.sort(hand);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }

        for(int i=0;i<n;i++){
            if(map.get(hand[i])!=0){
                int k = 0;
                while(k<groupSize){
                    if(!map.containsKey(hand[i]+k)){
                        return false;
                    }
                    int count = map.get(hand[i]+k);
                    count=count-1;
                    map.put(hand[i]+k,count);
                    if(map.get(hand[i]+k)<0){
                        return false;
                    }
                    k++;
                }
            }
        }
        return true;
    }
}
