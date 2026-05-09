
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] used = new int[n+1];
        Set<Integer> nodes = new HashSet<>();
        if(dfs(adj,used,1,0,nodes)){
            return new int[0];
        }
        for(int i=n-1;i>=0;i--){
            if(nodes.contains(edges[i][0]) && nodes.contains(edges[i][1])){
                return edges[i];
            }
        }
        return new int[0];
        
        
    }

    private boolean dfs(List<List<Integer>> parentList, int[] used, int vertice,int callingVertice,Set<Integer> cycleNodes){
        if(used[vertice]==1){
            cycleNodes.add(vertice);
            return false;
        }
        used[vertice]=1;
        List<Integer> list = parentList.get(vertice);
        for(int v : list){

            if(v==callingVertice){
                continue;
            }

            if(!dfs(parentList,used,v,vertice,cycleNodes)){
                if(!cycleNodes.contains(-1)){
                    if(cycleNodes.contains(vertice)){
                        cycleNodes.add(-1);
                    }
                    else{cycleNodes.add(vertice);}
                }
                return false;
            }
        }
        return true;
    }
}


