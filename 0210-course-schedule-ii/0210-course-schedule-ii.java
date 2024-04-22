class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    boolean[] visited;
    boolean[] onStack;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onStack = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++)
            graph.put(i, new ArrayList<>());
        
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            graph.get(prereq).add(course);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && !dfs(i))
                return new int[0];
        }
        
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            res[i] = ans.get(numCourses - 1 - i);
        
        return res;
    }

    public boolean dfs(int node) {
        if (onStack[node]) return false;
        if (visited[node]) return true;
        
        onStack[node] = true;
        visited[node] = true;
        
        for (int neighbor : graph.get(node)) {
            if (!dfs(neighbor)) {
                return false;
            }
        }
        
        onStack[node] = false;
        ans.add(node);
        
        return true;
    }
}
