import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static int minTimeToRotOranges(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Initialize a queue and count fresh oranges
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Enqueue all rotten oranges and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // If there are no fresh oranges, return 0 (all oranges are already rotten)
        if (freshCount == 0) {
            return 0;
        }

        // Direction vectors for up, down, left, right
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int timeElapsed = 0;

        // BFS to rot fresh oranges
        while (!queue.isEmpty()) {
            timeElapsed++;
            int size = queue.size();

            // Process all the oranges at the current time step
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];

                // Check all 4 adjacent cells
                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    // If the neighboring cell is a fresh orange, rot it
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2; // Mark it as rotten
                        queue.add(new int[] { nx, ny });
                        freshCount--;
                    }
                }
            }

            // If all fresh oranges are rotted, return timeElapsed
            if (freshCount == 0) {
                return timeElapsed;
            }
        }

        // If there are still fresh oranges left, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 2, 1, 0, 2, 1 },
                { 0, 0, 1, 2, 1 },
                { 1, 0, 0, 2, 1 }
        };

        System.out.println(pratice(grid)); // Output: 2
    }

    public static int pratice(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int freshCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) {
            return 0;
        }

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int timeElapsed = 0;

        while (!q.isEmpty()) {
            int qsize = q.size();
            timeElapsed++;

            for (int i = 0; i < qsize; i++) {
                int[] point = q.poll();
                int x = 0;
                int y = 0;
                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && nx <= r && ny >= 0 && ny <= c & grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        q.add(new int[] { nx, ny });
                        freshCount--;
                }
            }
            if (freshCount == 0) {
                return timeElapsed;
            }
        }

        return -1;
    }
}
