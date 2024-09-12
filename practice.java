public class practice{
    public static void main(String[] args) {
        int [] arr =  {10,9,11,6,15,2};
        int n = arr.length;
        printArray(arr);
        selectionSort(arr,n);
        printArray(arr);
    }

    static void bubbleSort(int [] arr , int n){
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n-i - 1 ; j++) {
                if (arr[i]>arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    static void selectionSort(int[] arr , int n){
        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i]>arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}