public class binarySearch {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int low = 0;
        int high = arr.length - 1;
        System.out.println("Index of target is " + recursiveBS(arr, low, high, 6));
    }

    // iterative approach
    public static int bs(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (target < arr[mid]) {
                high = mid - 1;
            }
            if (target > arr[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }

    // recursive approach

    public static int recursiveBS(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (target > arr[mid]) {
            return recursiveBS(arr, mid + 1, high, target);
        } else {
            return recursiveBS(arr, low, mid - 1, target);
        }
    }
}
