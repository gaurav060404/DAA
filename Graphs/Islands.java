package Graphs;

class Islands {
    // Function to perform DFS traversal
    private static void dfs(char[][] grid, int i, int j) {
        // Base case: if the current cell is out of bounds or is water ('0'), return
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        // Mark the current cell as visited by changing it to '0'
        grid[i][j] = '0';

        // Visit all 8 possible neighbors (up, down, left, right, and diagonals)
        dfs(grid, i - 1, j); // Up
        dfs(grid, i + 1, j); // Down
        dfs(grid, i, j - 1); // Left
        dfs(grid, i, j + 1); // Right
        dfs(grid, i - 1, j - 1); // Upper-left diagonal
        dfs(grid, i - 1, j + 1); // Upper-right diagonal
        dfs(grid, i + 1, j - 1); // Lower-left diagonal
        dfs(grid, i + 1, j + 1); // Lower-right diagonal
    }

    // Function to count the number of islands
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }

        return numIslands;
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '1' },
                { '0', '0', '0', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };

        System.out.println("Number of islands: " + numIslands(grid));
    }
}
