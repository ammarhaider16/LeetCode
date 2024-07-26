class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1)
            return nums.length;

        HashSet<Integer> allNums = new HashSet<>();
        for (int num : nums) {
            allNums.add(num);
        }

        int maxSeqLen = 0;

        for (int num : nums) {
            if (!allNums.contains(num - 1)) 
            {
                int thisSeqLen = 1;
                int thisNum = num + 1;
                while (allNums.contains(thisNum)) {
                    thisSeqLen++;
                    thisNum++;
                }
                maxSeqLen = Math.max(maxSeqLen, thisSeqLen);
            }
        }
        return maxSeqLen;
    }
}