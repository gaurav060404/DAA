import java.util.Arrays;

class Item{
    int weight;
    int value;
    Item(int weight, int value){
        this.weight = weight;
        this.value = value;
    }
}

class knapSack{

    double frictionalKnapSack(Item[] arr, int W,int n){
        Arrays.sort(arr, (a, b) -> Double.compare((double)b.value / b.weight, (double)a.value / a.weight) );

        printArray(arr);
        
        double res = 0.0;

        for (int i = 0; i < n; i++) {
            if (arr[i].weight <= W) {
                res += arr[i].value;
                W -= arr[i].weight;
            } else {
                System.out.println(W + " " + arr[i].weight);
                res += arr[i].value * ((double)W / arr[i].weight);
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Item [] arr = {new Item(10, 60), new Item(20, 100), new Item(30, 120)};

        int W = 50;

        knapSack ks = new knapSack();
        
        System.out.println(ks.frictionalKnapSack(arr, W, arr.length));
    }

    private static void printArray(Item[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print("("+ arr[i].value + " " + arr[i].weight + ")");

        System.out.println();
    }
}