class Solution {
    public void moveZeroes(int[] nums) {
        int a = 0;
        while (a < nums.length) {
            if (nums[a] == 0) {
                int b = a;
                while (b<nums.length) {
                    if (nums[b]!=0) {
                        nums[a] = nums[b];
                        nums[b] = 0;
                        break;
                    }
                    b++;
                }
            }
            a++;
        }
    }
}