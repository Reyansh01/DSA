package Backtracking;

import java.util.Arrays;

public class NQueens {
    
    public static boolean isNQueens(int[][] board) {
        return findIfNQueens(board, 0);
    }

    public static boolean findIfNQueens(int[][] board, int row) {
        if(row == board.length) return true;
        for(int col = 0; col < board[0].length; col++) {
            if(isSafeToPutQueen(board, row, col)) {
                board[row][col] = 1;
                if(findIfNQueens(board, row + 1)) return true;
                board[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean isSafeToPutQueen(int[][] board, int row, int col) {
        // check for same row.
        for(int i = 0; i < board.length; i++) {
            if(board[row][i] == 1) return false;
        }

        // check for same column
        for(int i = 0; i < board[0].length; i++) {
            if(board[i][col] == 1) return false;
        }

        // check for upper left diagonal.
        int i, j;
        for(i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 1) return false;
        }

        // check for upper right diagonal.
        for(i = row, j = col; i >= 0 && j <= board[0].length - 1; i--, j++) {
            if(board[i][j] == 1) return false;
        }

        // check for lower left diagonal.
        for(i = row, j = col; i <= board.length - 1 && j >= 0; i++, j--) {
            if(board[i][j] == 1) return false;
        }

        // checl for lower right diagonal.
        for(i = row, j = col; i <= board.length - 1 && j <= board[0].length - 1; i++, j++) {
            if(board[i][j] == 1) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] board = new int[4][4];
        Arrays.stream(board).forEach(val -> Arrays.fill(val, 0));
        System.out.println(isNQueens(board));
    }

}
