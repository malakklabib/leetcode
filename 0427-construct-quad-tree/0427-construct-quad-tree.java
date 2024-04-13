/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    int n;
    int[][] grid;
    public Node construct(int[][] grid) {
        n = grid.length;
        this.grid = grid;
        return construct(0, n-1, 0, n-1);
    }
    public Node construct(int si, int ei, int sj, int ej){
        if(allSame(si,ei,sj,ej)){
            boolean val = grid[si][sj]==1;
            return new Node(val, true);
        }
        
        Node root = new Node();
        int midi = (ei-si)/2 + si;
        int midj = (ej-sj)/2 + sj;
        root.topLeft = construct(si,midi,sj,midj);
        root.topRight = construct(si,midi,midj+1,ej);
        root.bottomLeft = construct(midi+1,ei,sj,midj);
        root.bottomRight = construct(midi+1,ei,midj+1,ej);
        
        return root;
    }
    
    public boolean allSame(int si, int ei, int sj, int ej){
        int start = grid[si][sj];
        for(int k = si; k <= ei; k++){
            for(int l = sj; l <= ej; l++){
                if(grid[k][l]!=start)
                    return false;
            }
        }
        return true;
    }
}




