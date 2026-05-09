class Twitter {

    Map<Integer,Set<Integer>> followMap;
    Map<Integer,List<int[]>> tweetMap;
    int count=0;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        
    }
    
    public void postTweet(int userId, int tweetId) {
        List<int[]> list = tweetMap.getOrDefault(userId,new ArrayList<>());
        list.add(new int[]{count++,tweetId});
        tweetMap.put(userId,list);
    }
    
    public List<Integer> getNewsFeed(int userId) {
       PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
       Set<Integer> set = followMap.getOrDefault(userId,new HashSet<>());
       for(int follwer: set){
        List<int[]> list = tweetMap.getOrDefault(follwer,new ArrayList<>());
        for(int[] tweet : list){
            maxHeap.add(tweet);
        }
       }
       if(!set.contains(userId)){
        List<int[]> userList =tweetMap.getOrDefault(userId,new ArrayList<>());
        for(int[] tweet: userList){
            maxHeap.add(tweet);
        }
       }
       List<Integer> res = new ArrayList<>();
       for(int i=0;i<10;i++){
        if(!maxHeap.isEmpty()){
            res.add(maxHeap.poll()[1]);
        }
       }
       return res;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> set =  followMap.getOrDefault(followerId,new HashSet<>());
        set.add(followeeId);
        followMap.put(followerId,set);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set =  followMap.getOrDefault(followerId,new HashSet<>());
        set.remove(followeeId);
        followMap.put(followerId,set);
        
    }
}
