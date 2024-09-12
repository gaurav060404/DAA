import java.util.Arrays;

public class BinarySearch1 {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 56, 7, 94, 3, 7 };
        printArray(arr);
        Arrays.sort(arr);
        printArray(arr);
        System.out.println(bs(arr, 94, 0, arr.length));
    }

    static int bs(int[] arr, int ele, int low, int high) {
        int mid = low + (high - low) / 2;
        while (low < high) {
            if (ele == arr[mid]) {
                return mid;
            }
            if (ele > arr[mid]) {
                mid = bs(arr, ele, mid + 1, high);
            } else {
                mid = bs(arr, ele, low, mid - 1);
            }
        }
        return -1;
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}
