class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] grid = prerequisites;
        List<Integer>[] arrList  = new ArrayList[numCourses];
        for(int i=0;i<arrList.length;i++){
            arrList[i]=new ArrayList<>();
        }
        int[] inorder = new int[numCourses]; 
        for(int i=0;i<grid.length;i++){
           arrList[grid[i][1]].add(grid[i][0]);
           inorder[grid[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(inorder[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int course = q.poll();
            List<Integer> list = arrList[course];
            for(int i=0;i<list.size();i++){
                inorder[list.get(i)]--;
                if(inorder[list.get(i)]==0){
                    q.offer(list.get(i));
                }
            }
        }
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]!=0){
                return false;
            }
        }
        return true;
    }
}
