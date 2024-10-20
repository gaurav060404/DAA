import java.util.Arrays;

class robotGridUniquePaths {
    public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return countPaths(0, 0, m, n, dp);
    }

    public static int countPaths(int i, int j, int m, int n, int[][] dp) {
        if (i == (m - 1) && j == (n - 1))
            return 1;
        if (i >= m || j >= n)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];
        else
            return dp[i][j] = countPaths(i + 1, j, m, n, dp) + countPaths(i, j + 1, m, n, dp);
    }

    public static void main(String[] args) {
        System.out.println("Unique paths : " + uniquePaths(2, 3));
    }
}