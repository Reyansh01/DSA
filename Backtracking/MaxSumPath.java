package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class MaxSumPath {
    
    public static void main(String[] args) {
        
        // can iterate up or left only.
        // [[
        //     1,2,3
        //     4,8,2
        //     1,5,3
        // ]]

        List<List<Integer>> path = new ArrayList<>();
        path.add(new ArrayList<>(List.of(1, 2, 3)));
        path.add(new ArrayList<>(List.of(4, 8, 2)));
        path.add(new ArrayList<>(List.of(1, 5, 3)));
        System.out.println(maxPathSumBackTrack(path, path.size() - 1, path.get(0).size() - 1));

        List<List<Integer>> path2 = new ArrayList<>();
        path2.add(new ArrayList<>(List.of(3, 7)));
        path2.add(new ArrayList<>(List.of(9, 8)));
        System.out.println(maxPathSumBackTrack(path2, path2.size() - 1, path2.get(0).size() - 1));
        int[][] dp = new int[path2.size()][path2.get(0).size()];
        for(int i = 0; i < path2.size(); i++) {
            for(int j = 0; j < path2.get(0).size(); j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(maxPathSumDP(path2, path2.size() - 1, path2.get(0).size() - 1, dp));
    }

    private static int maxPathSumBackTrack(List<List<Integer>> path, int row, int col) {
        if(row == 0) return path.get(row).get(col) + (col > 0 ? maxPathSumBackTrack(path, row, col - 1) : 0);
        if(col == 0) return path.get(row).get(col) + (row > 0 ? maxPathSumBackTrack(path, row - 1, col) : 0);

        return path.get(row).get(col) + Math.max(maxPathSumBackTrack(path, row - 1, col), maxPathSumBackTrack(path, row, col - 1));
    }

    private static int maxPathSumDP(List<List<Integer>> path, int row, int col, int[][] dp) {
        if(row == 0) return path.get(row).get(col) + (col > 0 ? maxPathSumDP(path, row, col - 1, dp) : 0);
        if(col == 0) return path.get(row).get(col) + (row > 0 ? maxPathSumDP(path, row - 1, col, dp) : 0);

        if(dp[row][col] != -1) {
            return dp[row][col];
        }

        return path.get(row).get(col) + Math.max(maxPathSumDP(path, row - 1, col, dp), maxPathSumDP(path, row, col - 1, dp));
    }

}
