class Solution {
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            int startVal = nums[start];
            int currVal = nums[middle];
            if (currVal == target) {
                return middle;
            }
            if (currVal >= startVal) {
                if (target > currVal || target < startVal)
                    start = middle + 1;
                else
                    end = middle - 1;
            } else {
                if (target < currVal || target > nums[end]) {
                    end = middle - 1;
                } else
                    start = middle + 1;
            }
        }

        return -1;
    }
}