class Solution {
        public int[] searchRange(int[] nums, int target) {

        int[] pos = { -1, -1 };

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] == target) {
                pos[0] = pos[1] = middle; 
                int mid = middle;               
                while (mid>=1 && nums[mid - 1]== target) {
                    pos[0] = mid-1;
                    mid--;
                }
                while (middle<nums.length-1 && nums[middle+1]==target) {
                    pos[1] = middle+1;
                    middle++;
                }
                return pos;

            } else if (target > nums[middle])
                start = middle + 1;
            else
                end = middle - 1;
        }

        return pos;
    }
}