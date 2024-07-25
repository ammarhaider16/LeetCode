class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] toReturn = new int[2];
        HashMap<Integer, Integer> differences = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (differences.containsKey(nums[i])) {
                toReturn[0] = i;
                toReturn[1] = differences.get(nums[i]);
                return toReturn;
            } else {
                int difference = target - nums[i];
                differences.put(difference, i);
            }
        }
        return null;
    }
}