// Last updated: 10/3/2025, 7:39:37 PM
import java.util.*;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        // Edge case: empty or too small grid
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;

        // Min-heap to always process the lowest-height boundary first
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((a, b) -> a.height - b.height);

        // Visited matrix to mark processed cells
        boolean[][] visited = new boolean[m][n];

        // Step 1: Add all boundary cells to the heap
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    minHeap.offer(new Cell(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }

        // Directions for BFS (up, down, left, right)
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int totalWater = 0;

        // Step 2: Process heap
        while (!minHeap.isEmpty()) {
            Cell cell = minHeap.poll();

            // Step 3: Visit neighbors
            for (int[] dir : directions) {
                int nr = cell.row + dir[0];
                int nc = cell.col + dir[1];

                // Skip if out of bounds or already visited
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;

                // If neighbor is lower, water can be trapped
                if (heightMap[nr][nc] < cell.height) {
                    totalWater += cell.height - heightMap[nr][nc];
                }

                // Push neighbor into heap with updated effective height
                int newHeight = Math.max(heightMap[nr][nc], cell.height);
                minHeap.offer(new Cell(nr, nc, newHeight));
            }
        }

        return totalWater;
    }

    // Helper class to store cell info
    static class Cell {
        int row;
        int col;
        int height;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}
