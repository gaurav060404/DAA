public class knapSack2 {
    public static void main(String[] args) {
        int[] wt = {1,2,2,3};
        int[] val = {10,12,15,20};
        int W = 5;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));    
    }

    // Function to return the maximum value that can be put in a knapsack of capacity W
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
}
