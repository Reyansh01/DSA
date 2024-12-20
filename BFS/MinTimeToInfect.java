package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class MinTimeToInfect {
    
    public static void main(String[] args) {
        int[][] grid = {
            {2,1,0},
            {1,1,0},
            {0,1,1}
        };

        int[][] grid2 = {
            {2,1,0},
            {1,1,1},
            {1,0,2}
        };

        // edge case because one would never be infected
        int[][] grid3 = {
            {2,1,0},
            {0,1,0},
            {1,0,2}
        };

        System.out.println("Time for grid 1: " + minTimeToInfect(grid));
        System.out.println();
        System.out.println("Time for grid 2: " + minTimeToInfect(grid2));
        System.out.println();
        System.out.println("Time for grid 3: " + minTimeToInfect(grid3));
    }

    private static int minTimeToInfect(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int nonInfected = 0;
        Queue<Pair> queue = new LinkedList<>();
        int[][] visited = new int[rows][columns];

        // populate queue with infected ones
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0)); // {(0, 0, 0)}
                    visited[i][j] = 2;
                }
                if(grid[i][j] == 1) nonInfected++;
            }
        }

        System.out.println("nonInfected cells: " + nonInfected);

        // print initial visited matrix
        System.out.println("Printing initial visited matrix");
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }

        int minTime = 0, count = 0;
        int[] rowDir = {-1, 0, 1, 0};
        int[] colDir = {0, 1, 0, -1};
        // to be implemented
        // int[][] rowColDir = {{0, -1}, {0, 1}, {1, 0}, {0, -1}};

        while(!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().column;
            int time = queue.peek().time;
            minTime = Math.max(minTime, time); // because after every iteration the time will increase. Hence, max is required here.
            queue.poll();
            for(int i = 0; i < 4; i++) { // because we have 4 directions to iterate over.
                int nextRow = row + rowDir[i];
                int nextCol = col + colDir[i];
                // for 2-D direction array (rowColDir)
                // int nextRow = row + rowColDir[i][0];
                // int nextCol = col + rowColDir[i][1];
                if(nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < columns && visited[nextRow][nextCol] != 2 && grid[nextRow][nextCol] == 1) {
                    queue.add(new Pair(nextRow, nextCol, time + 1));
                    visited[nextRow][nextCol] = 2;
                    count++;
                }
            }
        }

        System.out.println("count to compare with nonInfected cells: " + count);
        return count == nonInfected ? minTime : -1;
    }

    public static class Pair {
        int row;
        int column;
        int time;

        public Pair(int row, int column, int time) {
            this.row = row;
            this.column = column;
            this.time = time;
        }
    }

}
