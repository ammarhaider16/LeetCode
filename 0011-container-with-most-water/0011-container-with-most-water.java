class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            int a = height[start];
            int b = height[end];
            int thisArea;
            if (a >= b) {
                thisArea = b * (end - start);
                end--;
            } else {
                thisArea = a * (end - start);
                start++;
            }
            if (thisArea > maxArea)
                maxArea = thisArea;
        }
        return maxArea;
    }
}