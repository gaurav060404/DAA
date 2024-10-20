import java.util.Arrays;

public class AggressiveCows {

    // Function to check if we can place cows with a minimum distance of 'minDist'
    private static boolean canPlaceCows(int[] stalls, int n, int cows, int minDist) {
        // Place the first cow at the first stall
        int lastPosition = stalls[0];
        int count = 1; // One cow is placed at the first stall

        // Try to place the rest of the cows
        for (int i = 1; i < n; i++) {
            if (stalls[i] - lastPosition >= minDist) {
                count++;
                lastPosition = stalls[i]; // Place the cow in the current stall
            }

            // If all cows are placed, return true
            if (count == cows) {
                return true;
            }
        }

        // If not all cows are placed, return false
        return false;
    }

    // Function to find the largest minimum distance between cows
    public static int largestMinDistance(int[] stalls, int n, int cows) {
        // Sort the stalls in increasing order of position
        Arrays.sort(stalls);

        // Binary search on the answer
        int left = 1; // Minimum possible distance
        int right = stalls[n - 1] - stalls[0]; // Maximum possible distance
        int best = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            // Check if it's possible to place all cows with at least 'mid' distance
            if (canPlaceCows(stalls, n, cows, mid)) {
                best = mid; // Mid is a valid answer, try for a larger distance
                left = mid + 1;
            } else {
                right = mid - 1; // Mid is too large, reduce the distance
            }
        }

        return best; // Return the largest minimum distance
    }

    public static void main(String[] args) {
        int n = 5; // Number of stalls
        int cows = 3; // Number of cows
        int[] stalls = { 1, 2, 8, 4, 9 }; // Stall positions

        System.out.println("Largest minimum distance: " + largestMinDistance(stalls, n, cows)); // Output: 3
    }
}
