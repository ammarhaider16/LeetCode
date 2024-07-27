class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        Stack<int[]> nge = new Stack<>();

        for (int i = 0; i < len; i++) {
            ans[i] = -1;
            int num = nums[i];
            while (!nge.isEmpty() && num > nge.peek()[0]) {
                nge.pop();
            }
            int[] addNumIdx = { num, i };
            nge.push(addNumIdx);
        }

        for (int i = 0; i < len; i++) {
            int num = nums[i];
            while (!nge.isEmpty() && num > nge.peek()[0]) {
                int[] val = nge.pop();
                int valIdx = val[1];
                ans[valIdx] = num;
            }
            int[] addNumIdx = { num, i };
            nge.push(addNumIdx);
        }
        return ans;
    }
}