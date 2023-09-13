class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;
        String currentPosition = x + "," + y;
        visited.add(currentPosition);

        for (char c : path.toCharArray()) {
            switch (c) {
                case 'N':
                    x++;
                    break;
                case 'S':
                    x--;
                    break;
                case 'E':
                    y++;
                    break;
                case 'W':
                    y--;
                    break;
            }

            currentPosition = x + "," + y;
            if (visited.contains(currentPosition))
                return true;
            
            visited.add(currentPosition);
        }

        return false;
    }
}
