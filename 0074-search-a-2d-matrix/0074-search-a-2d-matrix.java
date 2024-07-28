class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0])
            return false;

        int len = matrix.length;
        int[] rowStart = new int[len];
        for (int i = 0; i < len; i++) {
            rowStart[i] = matrix[i][0];
        }

        int start = 0;
        int end = len - 1;
        int toStart = -1;
        while (toStart == -1) {
            int middle = (start + end) / 2;
            int current = rowStart[middle];
            if (target < current)
                end = middle - 1;
            else if (target > current) {
                if (middle < len - 1 && target >= rowStart[middle + 1])
                    start = middle + 1;
                else {
                    toStart = middle;
                }
            } else
                return true;
        }

        int[] searchRow = matrix[toStart];
        start = 0;
        end = searchRow.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            int current = searchRow[middle];
            if (target > current)
                start = middle + 1;
            else if (target < current)
                end = middle - 1;
            else
                return true;
        }
        return false;
    }
}