class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        HashMap<Integer, Integer> numToIdx = new HashMap<>();
        Stack<int[]> ngeStack = new Stack<>();
        int[] elemNGE = new int[nums2.length];
        for (int currIdx = 0; currIdx < nums2.length; currIdx++) {
            int num = nums2[currIdx];
            elemNGE[currIdx] = -1;
            while (!ngeStack.isEmpty() && num > ngeStack.peek()[0]) {
                int elemIdx = ngeStack.pop()[1];
                elemNGE[elemIdx] = num;
            }
            int[] numIdx = { num, currIdx };
            ngeStack.push(numIdx);
            numToIdx.put(num, currIdx);
        }

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = elemNGE[numToIdx.get(nums1[i])];
        }

        return ans;
    }
}