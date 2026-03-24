import java.util.*;

// Main class
public class PalindromeCheckerApp {

    // ----------- Different Algorithms -----------

    // 1. Two Pointer Approach
    public static boolean twoPointerCheck(String input) {
        String str = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int start = 0, end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // 2. Stack Approach
    public static boolean stackCheck(String input) {
        String str = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // 3. Deque Approach
    public static boolean dequeCheck(String input) {
        String str = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            deque.add(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    // ----------- Performance Measurement -----------

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Two Pointer timing
        long start1 = System.nanoTime();
        boolean res1 = twoPointerCheck(input);
        long end1 = System.nanoTime();

        // Stack timing
        long start2 = System.nanoTime();
        boolean res2 = stackCheck(input);
        long end2 = System.nanoTime();

        // Deque timing
        long start3 = System.nanoTime();
        boolean res3 = dequeCheck(input);
        long end3 = System.nanoTime();

        // ----------- Results -----------

        System.out.println("\nResults:");

        System.out.println("Two Pointer: " + (res1 ? "Palindrome" : "Not Palindrome")
                + " | Time: " + (end1 - start1) + " ns");

        System.out.println("Stack: " + (res2 ? "Palindrome" : "Not Palindrome")
                + " | Time: " + (end2 - start2) + " ns");

        System.out.println("Deque: " + (res3 ? "Palindrome" : "Not Palindrome")
                + " | Time: " + (end3 - start3) + " ns");

        sc.close();
    }
}