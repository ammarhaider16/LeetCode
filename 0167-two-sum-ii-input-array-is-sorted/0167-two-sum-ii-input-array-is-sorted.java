class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int head = 0;
        int tail = numbers.length-1;
        
        while (tail >= 0) {
            if (numbers[head]+numbers[tail]<target) head++;
            else if (numbers[head]+numbers[tail]>target) tail--;
            else {
                int[] idx = {head+1, tail+1};
                return idx;
            }
        }

        return null;        
    }
}