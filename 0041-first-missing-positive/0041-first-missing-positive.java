class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> allNums = new HashSet<>();
        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {
            allNums.add(num);
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        if (min > 1 || max < 0)
            return 1;

        for (int i = Math.max(1, min); i <= max; i++) {
            if (!allNums.contains(i) && i > 0)
                return i;
        }
        return max + 1;
    }
}