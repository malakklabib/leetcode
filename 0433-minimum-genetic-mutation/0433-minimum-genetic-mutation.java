class Solution {
    char[] letters = new char[]{'A','C','G','T'};
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> valid = new HashSet<>();
        for(String gene: bank)
            valid.add(gene);
        if(!valid.contains(endGene))
            return -1;
        
        Set<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>(); 
        queue.add(startGene);
        seen.add(startGene);
        int steps = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String currGene = queue.remove();
                if(currGene.equals(endGene))
                    return steps;
                for(int j = 0; j < 8; j++){
                    for(String newGene: perms(currGene,j)) {
                        if(!seen.contains(newGene) && valid.contains(newGene)) {
                            seen.add(newGene);
                            queue.add(newGene);
                        }
                    }
                } 
            }
            steps++;
        }
        return -1;
    }
    public List<String> perms(String gene, int index){
        List<String> res = new ArrayList<>();
        for(char letter: letters) {
            if(gene.charAt(index)!=letter){
                String newGene = gene.substring(0,index)+letter+gene.substring(index+1);
                res.add(newGene);
            }
        }
        return res;
    }
}