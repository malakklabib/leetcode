
class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] times = new double[n];
        Arrays.fill(times, -1);  // Initialize all times to -1 (meaning no collision)
        Stack<Integer> stack = new Stack<>();

        // Iterate from the last car to the first car
        for (int i = n - 1; i >= 0; i--) {
            int position = cars[i][0];
            int speed = cars[i][1];

            // Maintain the stack such that we always have a feasible scenario for collision
            while (!stack.isEmpty()) {
                int j = stack.peek();
                int positionNext = cars[j][0];
                int speedNext = cars[j][1];
                
                if (speed <= speedNext || 
                    (times[j] != -1 && (positionNext - position) / (double)(speed - speedNext) >= times[j])) {
                    // Current car i won't ever catch up with car j
                    stack.pop();
                } else {
                    break;
                }
            }
            
            if (!stack.isEmpty()) {
                int j = stack.peek();
                times[i] = (cars[j][0] - position) / (double)(speed - cars[j][1]);
            }
            stack.push(i);
        }

        return times;
    }
}

