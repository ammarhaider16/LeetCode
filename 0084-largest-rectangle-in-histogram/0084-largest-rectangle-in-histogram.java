class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int maxArea = 0;
        Stack<int[]> heightStartIdxStack = new Stack<>();

        for (int i = 0; i < len; i++) {
            int currHeight = heights[i];
            int currStartIdx = i;
            while (!heightStartIdxStack.isEmpty() && currHeight < heightStartIdxStack.peek()[0]) {
                int[] maxHeightStartIdx = heightStartIdxStack.pop();
                int startIdx = maxHeightStartIdx[1];
                int maxHeight = maxHeightStartIdx[0];
                currStartIdx = startIdx;
                int width = i - startIdx;
                int area = maxHeight * width;
                if (area > maxArea)
                    maxArea = area;
            }
            int[] heightStartIdx = { currHeight, currStartIdx };
            heightStartIdxStack.push(heightStartIdx);
        }
        while (!heightStartIdxStack.isEmpty()) {
            int[] maxHeightStartIdx = heightStartIdxStack.pop();
            int startIdx = maxHeightStartIdx[1];
            int maxHeight = maxHeightStartIdx[0];
            int width = len - startIdx;
            int area = maxHeight * width;
            if (area > maxArea)
                maxArea = area;
        }

        return maxArea;
    }
}