import java.util.*;

// Main class (same as file name)
public class PalindromeCheckerApp {

    // Strategy Interface
    interface PalindromeStrategy {
        boolean check(String input);
    }

    // Stack Strategy
    static class StackStrategy implements PalindromeStrategy {

        public boolean check(String input) {
            String processed = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

            Stack<Character> stack = new Stack<>();

            for (char c : processed.toCharArray()) {
                stack.push(c);
            }

            for (char c : processed.toCharArray()) {
                if (c != stack.pop()) {
                    return false;
                }
            }

            return true;
        }
    }

    // Deque Strategy
    static class DequeStrategy implements PalindromeStrategy {

        public boolean check(String input) {
            String processed = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

            Deque<Character> deque = new ArrayDeque<>();

            for (char c : processed.toCharArray()) {
                deque.add(c);
            }

            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Strategy:");
        System.out.println("1. Stack");
        System.out.println("2. Deque");

        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Strategy selection
        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        boolean result = strategy.check(input);

        if (result) {
            System.out.println("It is a palindrome ✅");
        } else {
            System.out.println("Not a palindrome ❌");
        }

        sc.close();
    }
}