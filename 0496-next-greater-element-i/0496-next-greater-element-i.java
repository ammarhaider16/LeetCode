class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        HashMap<Integer, Integer> numToNGE = new HashMap<>();
        Stack<Integer> ngeStack = new Stack<>();
        for (int currIdx = 0; currIdx < nums2.length; currIdx++) {
            int num = nums2[currIdx];
            numToNGE.put(num, -1);
            while (!ngeStack.isEmpty() && num > ngeStack.peek()) {
                int elem = ngeStack.pop();
                numToNGE.put(elem, num);
            }
            ngeStack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = numToNGE.get(nums1[i]);
        }

        return ans;
    }
}