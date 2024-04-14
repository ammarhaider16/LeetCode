class Solution {
    public int search(int[] nums, int target) {
        if (nums[0] == target) return 0;

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int middle = 1 + (start + end) / 2;

            if (nums[middle] == target)
                return middle;
            if (target > nums[middle])
                start = middle;
            if (target < nums[middle])
                end = middle - 1;
        }

        return -1;
    }
}