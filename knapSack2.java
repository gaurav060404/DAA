public class knapSack2 {
    public static void main(String[] args) {

        System.out.println(knapSackBackTracking(W, wt, val, n));
    }

    // Function to return the maximum value that can be put in a knapsack of
    // capacity W
    static int knapSack(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][W + 1];

        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Return the maximum value that can be put in a knapsack of capacity W
        return dp[n][W];
    }

    // Function to return the maximum value/profit that can be put in a knapsack of
    // capacity W using backtracking
    static int knapSackBackTracking(int W, int[] wt, int[] val, int n) {
        return knapSackHelper(W, wt, val, n, 0, 0, 0);
    }

    // Helper function for backtracking
    static int knapSackHelper(int W, int[] wt, int[] val, int n, int index, int currentWeight, int currentValue) {
        // Base case: if we have considered all items
        if (index == n) {
            return currentValue;
        }

        // Case 1: Do not include the current item
        int exclude = knapSackHelper(W, wt, val, n, index + 1, currentWeight, currentValue);

        // Case 2: Include the current item (if it doesn't exceed the capacity)
        int include = 0;
        if (currentWeight + wt[index] <= W) {
            include = knapSackHelper(W, wt, val, n, index + 1, currentWeight + wt[index], currentValue + val[index]);
        }

        // Return the maximum value of the two cases
        return Math.max(exclude, include);
    }
}
