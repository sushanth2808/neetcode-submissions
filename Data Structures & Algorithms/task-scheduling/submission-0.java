class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<int[]> p = new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));

        int[] arr = new int[26];
        for(int i=0;i<tasks.length;i++){
            arr[tasks[i]-'A']++;
        } 

        for(int i=0;i<26;i++){
            if(arr[i]!=0){
                p.add(new int[]{i,arr[i]});
            }   
        }

        Queue<int[]> q = new LinkedList<>();
        int count=0;
        while(!p.isEmpty() || !q.isEmpty()){
            if(!p.isEmpty()){
            int[] a = p.poll();
            arr[a[0]]--;
            count++;
            if(arr[a[0]]>0){
                q.add(new int[]{a[0],count+n});
            }
            }
            else{
                count++;
            }
            while(!q.isEmpty() && q.peek()[1]==count){
                int[] b = q.poll();
                p.add(new int[]{b[0],arr[b[0]]});
            }
        }
        return count;
    }
}
