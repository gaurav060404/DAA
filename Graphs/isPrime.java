public class isPrime {
    private int number;
    private boolean isPrime;

    public isPrime(int n) {
        this.number = n;
        this.isPrime = checkPrime(number);
    }

    private static boolean checkPrime(int n) {

        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return number + " is " + (isPrime ? "a prime number." : "not a prime number.");
    }

    public static void main(String[] args) {
        System.out.println(new isPrime(4));
    }
}
