class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 2)
            return Math.min(nums[0], nums[1]);

        int start = 0;
        int end = nums.length - 1;
        int currentMin = nums[0];

        while (start <= end) {
            int current = (start + end) / 2;
            int elem = nums[current];
            if (elem > currentMin) {
                start = current + 1;
            } else if (elem <= currentMin) {
                currentMin = elem;
                end = current - 1;
            }
        }
        return currentMin;
    }
}