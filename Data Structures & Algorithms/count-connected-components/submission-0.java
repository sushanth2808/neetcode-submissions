class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            map.computeIfAbsent(edges[i][0],k->new ArrayList<>()).add(edges[i][1]);
            map.computeIfAbsent(edges[i][1],k->new ArrayList<>()).add(edges[i][0]);
        }
        int[] used = new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(used[i]==0){
                count++;
                dfs(edges,n,map,used,i);
            }
        }
        return count;
    }

    private void dfs(int[][] edges, int n , Map<Integer,List<Integer>> map, int[] used, int vertice){
        used[vertice]=1;
        List<Integer> list = map.getOrDefault(vertice,new ArrayList<>());
        for(int v : list){
            if(used[v]==1){
                continue;
            }
            dfs(edges,n,map,used,v);
        }
    }
}

