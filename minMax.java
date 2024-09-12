public class minMax {

    static class Pair{
        int min;
        int max;
    }
    
    public static void main(String[] args) {
        int [] arr = {2,4,68,14,83,0};
        Pair res = findMM(arr, 0, arr.length-1);
        System.out.println(res.max);
        System.out.println(res.min);
    }

    static Pair findMM(int[]arr,int low,int high){
        Pair result = new Pair();
        Pair left , right ;

        if(low==high){
            result.min = arr[low];
            result.max = arr[low];
            return result;
        }
        if(high == low + 1){
            if(arr[low]<arr[high]){
                result.min = arr[low];
                result.max = arr[high];
            }else{
            result.min = arr[high];
            result.max = arr[low];
            }
            return result;
        }

        int mid = (low+high)/2;

        left = findMM(arr, low, mid);
        right = findMM(arr, mid + 1, high);
        
        result.max = Math.max(left.max, right.max);
        result.min = Math.min(left.min, right.min);

        return result;
    }
}
