public class LCS {
    static int longestCommonSubsequence(int m, int n, String a, String b, int dp[][]) {
        if (m == 0 || n == 0)
            return 0;
        if (dp[m][n] != -1)
            return dp[m][n];

        if (a.charAt(m - 1) == b.charAt(n - 1))
            return dp[m][n] = 1 + longestCommonSubsequence(m - 1, n - 1, a, b, dp);
        else
            return dp[m][n] = Math.max(longestCommonSubsequence(m, n - 1, a, b, dp),
                    longestCommonSubsequence(m - 1, n, a, b, dp));
    }

    public static void main(String[] args) {
        String a = "ABCAB";
        String b = "AECB";
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.println(dp[i][j]);
            }
            System.err.println();
        }

        System.out.println(longestCommonSubsequence(m, n, a, b, dp));
    }
}
