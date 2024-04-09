class Solution {
    Set<Integer> seen = new HashSet<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        for(int[] prerequisite: prerequisites){
            List<Integer> neighbors = map.getOrDefault(prerequisite[0], new ArrayList<>());
            neighbors.add(prerequisite[1]);
            map.put(prerequisite[0], neighbors);
        }
        
        for(int[] prerequisite: prerequisites){
            if(dfs(prerequisite[0],new HashSet<>()))
                return false;
        }
        
        return true;
    }
    
    public boolean dfs(int node, Set<Integer> visited){
        if(visited.contains(node))
            return true;
        
        if(seen.contains(node))
            return false;
        
        seen.add(node);
        visited.add(node);
        
        if(map.containsKey(node)){
            for(int neigh: map.get(node)) {
                if(dfs(neigh, visited))
                    return true;
            }
        }
        
        visited.remove(node);
        return false;
    }
}