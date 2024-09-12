public class maxMin {
    /**
     * InnermaxMin
     */
    static class Pair {
        int max;
        int min;
    }

    public static void main(String[] args) {
        int[] arr = { 38, 27, 10, 43 };
        Pair result = findMaxMin(arr, 0, arr.length - 1);

        System.out.println(result.max);
        System.out.println(result.min);
    }

    static Pair findMaxMin(int[] arr, int low, int high) {
        Pair result = new Pair();
        Pair left, right;
        if (low == high) {
            result.max = arr[low];
            result.min = arr[low];
            return result;  
        }
        if (high == low + 1) {
            if (arr[low] < arr[high]) {
                result.max = arr[high];
                result.min = arr[low];
            }else{
                result.max = arr[low];
                result.min = arr[high];
            }
            return result;
        }

        int mid = (low + high) / 2; 

        left = findMaxMin(arr, low, mid);
        right = findMaxMin(arr, mid+1, high);

        result.max = Math.max(left.max, right.max);
        result.min = Math.min(left.min,right.min);

        return result;
    }

    private static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}
