import java.util.Stack;

public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        // Traverse the number digit by digit
        for (int i = 0; i < num.length(); i++) {
            char currentDigit = num.charAt(i);

            // While k > 0 and the stack is non-empty, remove the top of the stack if it's
            // greater than the current digit
            while (k > 0 && !stack.isEmpty() && stack.peek() > currentDigit) {
                stack.pop();
                k--;
            }

            // Push the current digit onto the stack
            stack.push(currentDigit);
        }

        // If we still have digits to remove, remove from the end of the number (from
        // the stack)
        while (k > 0) {
            stack.pop();
            k--;
        }

        // Build the number from the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        result.reverse(); // Reverse the result as stack pops in reverse order

        // Remove leading zeros
        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        // Return the final result, or "0" if the result is empty
        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        // Example 1
        String num1 = "1432219";
        int k1 = 3;
        System.out.println(practice(num1, k1)); // Output: "1219"

        // Example 2
        String num2 = "10200";
        int k2 = 1;
        System.out.println(removeKdigits(num2, k2)); // Output: "200"

        // Example 3
        String num3 = "10";
        int k3 = 2;
        System.out.println(removeKdigits(num3, k3)); // Output: "0"
    }

    public static String practice(String num, int k) {
        Stack stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char curr = num.charAt(i);

            while (!stack.isEmpty() && k > 0 && stack.peek() > curr) {
                stack.pop();
                k--;
            }

            stack.push(curr);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        result.reverse(); // Reverse the result as stack pops in reverse order

        // Remove leading zeros
        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        // Return the final result, or "0" if the result is empty
        return result.length() == 0 ? "0" : result.toString();
    }
}
