public class practice2 {
    static class Pair {
        int max;
        int min;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 6, 9, 0, 4 };
        Pair res = maxMin(arr, 0, arr.length - 1);
        System.out.println(res.max + "  " + res.min);
    }

    static Pair maxMin(int[] arr, int low, int high) {
        Pair result = new Pair();
        Pair left, right;
        if (low == high) {
            result.min = arr[low];
            result.max = arr[low];
            return result;
        }
        if (high == low + 1) {
            if (arr[low] < arr[high]) {
                result.min = arr[low];
                result.max = arr[high];
            } else {
                result.min = arr[high];
                result.max = arr[low];
            }
            return result;
        }

        int mid = (low + high) / 2;

        left = maxMin(arr, low, mid);
        right = maxMin(arr, mid + 1, high);

        result.max = Math.max(left.max, right.max);
        result.min = Math.min(left.min, right.min);

        return result;
    }
}
