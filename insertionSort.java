public class insertionSort{
    public static void main(String[] args) {
        int[] arr = {2,5,14,4,90,53};
        System.out.println("Before Sorting");
        printArray(arr);
        sort(arr);
        System.out.println("After Sorting");
        printArray(arr);
    }
    public static void sort(int[]arr){
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = key;
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