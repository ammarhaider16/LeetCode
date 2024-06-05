class Solution {
    
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] posMat = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) posMat[i][j] = zeroPos(i, j, mat);
            }
        }

        return posMat;
    }

    public int zeroPos(int row, int col, int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int lowestDistance = Integer.MAX_VALUE - 1000;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    int thisDist = Math.abs(row - i) + Math.abs(col - j);
                    if (thisDist < lowestDistance)
                        lowestDistance = thisDist;
                }
            }
        }

        return lowestDistance;
    }

}
