package Backtracking;

public class SudokuSolver {

    public static boolean solveSudoku(char[][] board) {
        return findSudokuSolution(board, 0, 0);
    }

    public static boolean findSudokuSolution(char[][] board, int row, int col) {
        if (row == board.length)
            return true;

        // what should be the next row and column that needs to be checked in recursion.
        int newRow = 0, newCol = 0;
        if (col != board.length - 1) { // until we do not get the last column
            newRow = row;
            newCol = col + 1;
        } else { // we get the last column then:
            newRow = row + 1; // row would be increased.
            newCol = 0; // column would become the first one i.e. 0.
        }

        // number is already filled then just check it's validity.
        if (board[row][col] != '.') {
            if (findSudokuSolution(board, newRow, newCol)) {
                return true;
            }
        } else {
            for (int i = 1; i <= 9; i++) {
                if (isSafeInSudoku(board, row, col, i)) {
                    board[row][col] = (char) (i + '0'); // typecast int to char (digit).
                    if (findSudokuSolution(board, newRow, newCol)) {
                        return true;
                    } else {
                        board[row][col] = '.';
                    }
                }
            }
        }
        return false;
    }

    public static boolean isSafeInSudoku(char[][] board, int row, int col, int num) {
        for (int i = 0; i < board.length; i++) {
            // row check.
            if (board[i][col] == (char) (num + '0'))
                return false;
            // col check.
            if (board[row][i] == (char) (num + '0'))
                return false;
        }

        // check inside internal matrix of 3X3.
        int startingRow = (row / 3) * 3;
        int startingCol = (col / 3) * 3;

        for (int i = startingRow; i < startingRow + 3; i++) {
            for (int j = startingCol; j < startingCol + 3; j++) {
                if (board[i][j] == (char) (num + '0')) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char board[][] = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        if(solveSudoku(board)) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        } else 
            System.out.println("Can't solve sudoku..");
        
    }

}
