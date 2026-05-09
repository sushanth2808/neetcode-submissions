
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
        
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
        int[] used = new int[n+1];

        if(!dfs(adj,used,edge[0],0)){
            return edge;
            }
        }
        return new int[0];
    }

    private boolean dfs(List<List<Integer>> parentList, int[] used, int vertice,int callingVertice){
        if(used[vertice]==1){
            return false;
        }
        used[vertice]=1;
        List<Integer> list = parentList.get(vertice);
        for(int v : list){

            if(v==callingVertice){
                continue;
            }

            if(!dfs(parentList,used,v,vertice)){
                return false;
            }
        }
        return true;
    }
}


