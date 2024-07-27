class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        HashMap<Integer, Double> positionToTime = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int distance = target - position[i];
            double time = ((double) distance) / speed[i];
            positionToTime.put(position[i], time);
        }
        Arrays.sort(position);
        Stack<Double> fleetStack = new Stack<>();

        for (int i = len - 1; i >= 0; i--) {
            double time = positionToTime.get(position[i]);
            if (fleetStack.isEmpty() || time > fleetStack.peek()) {
                fleetStack.push(time);
            }
        }
        return fleetStack.size();
    }
}