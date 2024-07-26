class Solution {
    // ALGORITHM: TO IDENTIFY WHETHER A NUMBER IS A START OF A SEQUENCE, CHECK IF IT HAS LEFT NEIGHBORS. IF IT DOES NOT HAVE ANY LEFT NEIGHBOURS, CHECK HOW LONG THE SEQUENCE IS!

    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1)
            return nums.length;

        HashSet<Integer> allNums = new HashSet<>();
        for (int num : nums) {
            allNums.add(num);
        }

        int maxSeqLen = 0;

        for (int num : nums) {
            if (!allNums.contains(num - 1)) // if this number is a start of a sequence ...
            {
                int thisSeqLen = 1;
                int thisNum = num + 1;
                while (allNums.contains(thisNum)) {
                    thisSeqLen++;
                    thisNum++;
                }
                if (thisSeqLen > maxSeqLen)
                    maxSeqLen = thisSeqLen;
            }
        }

        return maxSeqLen;
    }
}