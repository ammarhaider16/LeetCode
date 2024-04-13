class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] returnArr = new int[2];
        Map myHash = Collections.synchronizedMap(new HashMap());

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (myHash.get(difference) != null) {
                returnArr[0] = i;
                returnArr[1] = (int) myHash.get(difference);
            } else
                myHash.put(nums[i], i);
        }

        return returnArr;
    }   
}