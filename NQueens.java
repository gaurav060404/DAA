public class NQueens {
    public static void main(String[] args) {
        int[][] board = new int[0][0];
        boolean result = solveNQ(board, 0);
        System.out.println("Is NQueens Solvable For The Given Board ?/n ->" + result);
    }

    public static boolean solveNQ(int[][] board, int row) {
        if (row == board.length)
            return true;

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                if (solveNQ(board, row + 1))
                    return true;
                board[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] board, int row, int col) {
        // Check this column on upper rows
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }

        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check upper diagonal on right side
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }
}
