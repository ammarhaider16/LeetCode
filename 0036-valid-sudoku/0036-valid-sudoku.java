class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            HashSet<Integer> rowNums = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    int ch = board[j][i] - '0';
                    if (rowNums.contains(ch)) {
                        System.out.println("repetiton in rows");
                        return false;
                    } else
                        rowNums.add(ch);
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            HashSet<Integer> colNums = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int ch = board[i][j] - '0';
                    if (colNums.contains(ch)){
                        System.out.println("repetiton in cols");
                        return false;
                    }
                    else
                        colNums.add(ch);
                }
            }
        }

        int row = 0;
        int col = 0;
        for (int i = 0; i < 9; i++) {
            if (i == 3 || i == 6) {
                row += 3;
                col = 0;
            }
            HashSet<Integer> gridNums = new HashSet<>();
            for (int j = row; j < row + 3; j++) {
                for (int k = col; k < col + 3; k++) {
                    if (board[j][k] != '.') {
                        int ch = board[j][k] - '0';
                        System.out.println(ch);
                        if (gridNums.contains(ch)) {
                            System.out.println("repetiton in grids");
                            return false;
                        }
                        else
                            gridNums.add(ch);
                    }
                }
            }
                col += 3;
        }
        return true;
    }
}