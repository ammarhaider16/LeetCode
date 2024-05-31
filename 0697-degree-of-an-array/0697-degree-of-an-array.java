class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer freq = map.get(num);
            if (freq == null)
                map.put(num, 1);
            else
                map.put(num, freq + 1);

        }
        HashSet<Integer> maxNums = new HashSet<Integer>();
        int maxFreq = 0;

        for (Integer num : map.keySet()) {
            int freq = map.get(num);
            if (freq > maxFreq) {
                maxNums.clear();
                maxFreq = freq;
                maxNums.add(num);
            } else if (freq == maxFreq) {
                maxNums.add(num);
            }
        }

        int smallestSubLen = nums.length;

        for (Integer num : maxNums) {
            int freq = map.get(num);
            int matches = 0;
            int len = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == num) {
                    matches++;
                }
                if (matches > 0)
                    len++;
                if (matches == freq)
                    break;
            }
            if (len < smallestSubLen)
                smallestSubLen = len;
        }
        return smallestSubLen;
    }
}