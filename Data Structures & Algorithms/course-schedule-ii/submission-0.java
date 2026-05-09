class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap();
        int n = prerequisites.length;
        for(int i=0;i<n;i++){
            List<Integer> adjList = map.getOrDefault(prerequisites[i][0],new ArrayList<>());
            adjList.add(prerequisites[i][1]);
            map.put(prerequisites[i][0],adjList);
        }
        int[] state = new int[numCourses];
        int[] res = new int[numCourses];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            if(!dfs(i,map,state,list)){
                return new int[0];
            };
        } 
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }

    private boolean dfs(int i, Map<Integer,List<Integer>> map,int[] state,List<Integer> res){
        if(state[i]==1){
            return false;
        }
        if(state[i]==2){return true;}
        state[i]=1; 
        List<Integer> list = map.getOrDefault(i,new ArrayList<>());
        for(int j=0;j<list.size();j++){
            if(!dfs(list.get(j),map,state,res)){
                return false;
            }
        }
        state[i]=2;
        res.add(i);
        return true;
    }


}

