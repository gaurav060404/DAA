public class mergeSort {
    public static void main(String[] args) {
        int[] arr = { 4, 2, 7, 1, 0 };
        System.out.println("Before Sorting :");
        printArray(arr);
        sort(arr, 0, arr.length - 1);
        System.out.println("After Sorting :");
        printArray(arr);
    }

    static void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        if (low < high) {
            int mid = (low + high) / 2;
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    static void merge(int[] arr, int low, int mid, int high) {
        int i, j, k;
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] LeftArray = new int[n1];
        int[] RightArray = new int[n2];

        for (int l = 0; l < n1; l++) {
            LeftArray[l] = arr[low + l];
        }

        for (int r = 0; r < n2; r++) {
            RightArray[r] = arr[mid + 1 + r];
        }

        i = 0;
        j = 0;
        k = low;

        while (i < n1 && j < n2) {
            if (LeftArray[i] <= RightArray[j]) {
                arr[k] = LeftArray[i];
                i++;
            } else {
                arr[k] = RightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = LeftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = RightArray[j];
            j++;
            k++;
        }

    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

}
