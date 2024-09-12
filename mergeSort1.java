public class mergeSort1 {
    public static void main(String[] args) {
        int [] arr = {38,27,10,43};
        printArray(arr);
        mergeSort(arr, 0, arr.length-1);
        printArray(arr);
    }

    static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    static void merge(int[]arr,int low,int mid,int high){
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int [] L = new int[n1 + 1];
        int [] R = new int[n2  + 1];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[low + i ];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j ];
        }

        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0 ; int j = 0 ; 
        for (int k = low ; k <= high ; k++) {
            if (L[i]<=R[j]) {
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
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
