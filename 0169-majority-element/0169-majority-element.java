class Solution {
    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else
                map.put(nums[i], 1);
        }

        Set<Integer> keys = map.keySet();

        for (Integer key : keys) {
            if (map.get(key) > nums.length / 2)
                return key;
        }

        return 0;
    }
}