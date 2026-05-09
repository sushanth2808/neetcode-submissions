class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap();
        int n = prerequisites.length;
        for(int i=0;i<n;i++){
            List<Integer> adjList = map.getOrDefault(prerequisites[i][0],new ArrayList<>());
            adjList.add(prerequisites[i][1]);
            map.put(prerequisites[i][0],adjList);
        }
        int[] used = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!dfs(i,map,used)){
                return false;
            };
        } 
        return true;  
    }

    private boolean dfs(int i, Map<Integer,List<Integer>> map,int[] used){
        if(used[i]==1){
            return false;
        }
        used[i]=1;
        List<Integer> list = map.getOrDefault(i,new ArrayList<>());
        for(int j=0;j<list.size();j++){
            if(!dfs(list.get(j),map,used)){
                return false;
            }
        }
        used[i]=0;
        return true;
    }


}
