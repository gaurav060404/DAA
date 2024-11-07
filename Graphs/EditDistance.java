public class EditDistance{
    public static int minEditDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // Create a 2D array to store the results of subproblems
        int[][] dp = new int[m + 1][n + 1];

        // Fill dp[][] in a bottom-up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                // If str1 is empty, insert all characters of str2
                if (i == 0) {
                    dp[i][j] = j; // j insertions
                }
                // If str2 is empty, remove all characters of str1 
                else if (j == 0) {
                    dp[i][j] = i; // i deletions
                }
                // If last characters are the same, no new operation is needed
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // If last characters are different, consider all operations and take the
                // minimum
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], // Replace
                            Math.min(dp[i][j - 1], // Insert
                                    dp[i - 1][j])); // Remove
                }
            }
        }

        // Return the result from the dp table
        return dp[m][n];
    }

    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";

        System.out.println("Minimum edit distance: " + minEditDistance(str1, str2));
    }
}
