class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] answer = new int[len];
        Stack<int[]> temps = new Stack<>();
        for (int currIdx = 0; currIdx < len; currIdx++) {
            int temp = temperatures[currIdx];
            while (!temps.isEmpty() && temp > temps.peek()[0]) {
                int tempIdx = temps.pop()[1];
                answer[tempIdx] = currIdx - tempIdx;
            }
            int[] tempAndIdx = { temp, currIdx };
            temps.push(tempAndIdx);
        }
        return answer;
    }
}