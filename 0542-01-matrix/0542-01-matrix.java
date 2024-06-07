class Solution {
    
        public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> zeros = new LinkedList<int[]>();
        int m = mat.length;
        int n = mat[0].length;
        int highVal = m * n;
        // Step 1: Initially adding things to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1)
                    mat[i][j] = highVal;
                else {
                    int[] idxs = {i, j};
                    zeros.add(idxs);
                } 
            } 
        }

        // Step 2: BFS Traversal 
        while (!zeros.isEmpty()) {
            int[] idxs = zeros.poll();
            int row = idxs[0];
            int col = idxs[1];
            
            // check left neighbour
            if (row > 0 && mat[row][col] + 1 < mat[row-1][col]) {
                mat[row-1][col] = mat[row][col] + 1;
                int[] toQ = {row-1,col};
                zeros.add(toQ);
            }
            // check right neighbour
            if (row < m - 1 && mat[row][col] + 1 < mat[row+1][col]) {
                mat[row+1][col] = mat[row][col] + 1;
                int[] toQ = {row+1,col};
                zeros.add(toQ);
            }

            // check top neighbour
            if (col > 0 && mat[row][col] + 1 < mat[row][col-1]) {
                mat[row][col-1] = mat[row][col] + 1;
                int[] toQ = {row,col-1};
                zeros.add(toQ);
            }

            // check bottom neighbour
            if (col < n - 1 && mat[row][col] + 1 < mat[row][col+1]) {
                mat[row][col+1] = mat[row][col] + 1;
                int[] toQ = {row,col+1};
                zeros.add(toQ);
            }
        }

        return mat;
    }

}
