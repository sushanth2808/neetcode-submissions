

class Solution {
public int[] findOrder(int numCourses, int[][] prerequisites) {
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
    int[] res = new int[numCourses];
    while(!q.isEmpty()){
        int course = q.poll();
        res[count]=course;
        count+=1;
        List<Integer> list = map.getOrDefault(course,new ArrayList<>());
        for(int i=0;i<list.size();i++){
            indegree[list.get(i)]--;
            if(indegree[list.get(i)]==0){
                q.add(list.get(i));
            }
        }
    }
    if(count==numCourses)
    {
        return res;
    }
    return new int[0];
}

}


