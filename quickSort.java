public class quickSort {
    public static void main(String[] args) {
        int[] arr = { 4, 6, 2, 5, 7, 9, 1, 3 };
        System.out.println("Before Sorting");
        printArray(arr);
        sort(arr, 0, arr.length-1);
        System.out.println("After Sorting");
        printArray(arr);
    }

    static void sort(int[]arr,int low,int high){
        int paritionIndex = partiton(arr, low, high);
        if(low<high){
            sort(arr, low,paritionIndex-1);
            sort(arr,paritionIndex+1, high);
        }
     }
    static int partiton(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low+1;
        int j = high;
        int temp;
        do{
            while (arr[i] <= pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if(i<j){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }while(i<j);
            return j;
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}
