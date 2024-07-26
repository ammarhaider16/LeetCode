class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] indices = new int[2];
        int start = 0;
        int end = numbers.length - 1;
        boolean sumFound = false;

        while (!sumFound) {
            int prev = numbers[start];
            int next = numbers[end];
            if (prev + next > target)
                end--;
            else if (prev + next < target)
                start++;
            else
                sumFound = true;
        }
        indices[0] = start+1;
        indices[1] = end+1;
        return indices;
    }
}