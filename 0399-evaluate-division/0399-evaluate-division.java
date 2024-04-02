
class Solution {
    double[] res;
    Map<String, List<String>> eqs = new HashMap<>();
    Map<Pair<String, String>, Double> vals = new HashMap<>();
    Set<Pair<String, String>> seen;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        buildHashMaps(equations, values);
        res = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            seen = new HashSet<>();
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1));
        }
        return res;
    }
    public double dfs(String source, String destination) {
        double ans = -1;
        if(!eqs.containsKey(source))
            return ans;
        if(eqs.get(source).contains(destination))
            return vals.get(new Pair<>(source,destination));
        for(String neighbor: eqs.get(source)) {
            Pair<String, String> p = new Pair<>(source, neighbor);
            if(!seen.contains(p)) {
                seen.add(p);
                double div = dfs(neighbor, destination);
                if(div!=-1)
                    ans = vals.get(new Pair<>(source,neighbor))*div;
            }
        }
        return ans;
    }
    public void buildHashMaps(List<List<String>> equations, double[] values) {
        for(int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];
            double inv = 1/val;

            Pair<String, String> pair1 = new Pair<>(a,b);
            Pair<String, String> pair2 = new Pair<>(b,a);
            
            vals.put(pair1, val);
            vals.put(pair2, inv);
            eqs.put(a,new ArrayList<>());
            eqs.put(b, new ArrayList<>());
        }
        for(List<String> equation: equations) {
            String a = equation.get(0);
            String b = equation.get(1);
            eqs.get(a).add(b);
            eqs.get(b).add(a);
        }
    }
}