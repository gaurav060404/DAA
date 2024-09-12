public class BubbleSort2 {
    public static void main(String[] args) {
        int[] arr = { 9, 4, 2, 10, 12, 11 };
        printArray(arr);
        sort(arr, arr.length);
        printArray(arr);
    }

    public static void sort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int bubble = arr[j];
                if (bubble > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1]; 
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}
