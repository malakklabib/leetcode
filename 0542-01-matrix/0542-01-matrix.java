class Solution {
    int m, n;
    boolean[][] seen;
    Queue<List<Integer>> queue = new LinkedList<>();
    int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        seen = new boolean[m][n];
        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new ArrayList<>(Arrays.asList(i, j)));
                    seen[i][j] = true;
                    ans[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            List<Integer> pos = queue.remove();
            int posX = pos.get(0), posY = pos.get(1);

            for (int[] dir : directions) {
                int row = dir[0] + posX;
                int col = dir[1] + posY;

                if (valid(row, col) && !seen[row][col]) {
                    seen[row][col] = true;
                    ans[row][col] = ans[posX][posY] + 1;
                    queue.add(new ArrayList<>(Arrays.asList(row, col)));
                }
            }
        }

        return ans;
    }

    public boolean valid(int row, int col) {
        return 0 <= row && row < m && 0 <= col && col < n;
    }
}
