class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            map.computeIfAbsent(edges[i][0],k->new ArrayList<>()).add(edges[i][1]);
            map.computeIfAbsent(edges[i][1],k->new ArrayList<>()).add(edges[i][0]);
        }
        int[] used = new int[n];

        if(!dfs(edges,n,map,used,0,-1)){
            return false;
        }else{
            for(int i=0;i<n;i++){
                if(used[i]==0){
                    return false;
                }
            }
            return true;
        }
    }

    private boolean dfs(int[][] edges, int n , Map<Integer,List<Integer>> map, int[] used, int vertice,int callingVertice){
        if(used[vertice]==1){
            return false;
        }
        used[vertice]=1;
        List<Integer> list = map.getOrDefault(vertice,new ArrayList<>());
        for(int v : list){
            if(v==callingVertice){
                continue;
            }
            if(!dfs(edges,n,map,used,v,vertice)){
                return false;
            }
        }
        return true;
    }
}
