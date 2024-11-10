public class quickSort1 {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 0, 5, 2, 0, 1 };
        printArray(arr);
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
    // static void quickSort(int arr[], int low, int high) {
    // if (low < high) {
    // int partitionIndex = partition(arr, low, high);
    // quickSort(arr, low, partitionIndex - 1);
    // quickSort(arr, partitionIndex + 1, high);
    // }
    // }
    // static int partition(int[] arr, int low, int high) {
    // int i = low + 1;
    // int j = high;
    // int pivot = arr[low];
    // int temp ;

    // do {
    // while (i <= high && arr[i] <= pivot) {
    // i++;
    // }
    // while (j >= low && arr[j] > pivot) {
    // j--;
    // }
    // if (i < j) {
    // temp = arr[i];
    // arr[i] = arr[j];
    // arr[j] = temp;
    // }
    // } while (i < j);

    // // Swap pivot with arr[j]
    // temp = arr[low];
    // arr[low] = arr[j];
    // arr[j] = temp;

    // return j;
    // }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        int temp;

        do {
            while (i <= high && arr[i] <= pivot) {
                i++;
            }

            while (j >= low && arr[j] > pivot) {
                j--;
            }

            if (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        } while (i < j);
        temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }
}
