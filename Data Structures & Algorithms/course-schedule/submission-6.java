class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap();
        int n = prerequisites.length;
        int[] indegree = new int[numCourses];
        for(int i=0;i<n;i++){
            List<Integer> adjList = map.getOrDefault(prerequisites[i][1],new ArrayList<>());
            adjList.add(prerequisites[i][0]);
            map.put(prerequisites[i][1],adjList);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int count=0;
        while(!q.isEmpty()){
            count+=1;
            int course = q.poll();
            List<Integer> list = map.getOrDefault(course,new ArrayList<>());
            for(int i=0;i<list.size();i++){
                indegree[list.get(i)]--;
                if(indegree[list.get(i)]==0){
                    q.add(list.get(i));
                }
            }
        }
        return count==numCourses;
    }

    // private boolean dfs(int i, Map<Integer,List<Integer>> map,int[] state){
    //     if(state[i]==2){return true;}
    //     if(state[i]==1){
    //         return false;
    //     }
    //     state[i]=1; 
    //     List<Integer> list = map.getOrDefault(i,new ArrayList<>());
    //     for(int j=0;j<list.size();j++){
    //         if(!dfs(list.get(j),map,state)){
    //             return false;
    //         }
    //     }
    //     state[i]=2;
    //     return true;
    // }


}
