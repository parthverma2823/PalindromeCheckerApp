import java.util.Scanner;

public class PalindromeCheckerApp {

    // Inner class (Palindrome Service)
    static class PalindromeChecker {

        // Public method (exposed service)
        public boolean checkPalindrome(String input) {

            // Normalize string (ignore case, spaces, special chars)
            String processed = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

            int start = 0;
            int end = processed.length() - 1;

            while (start < end) {
                if (processed.charAt(start) != processed.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }

            return true;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("It is a palindrome ✅");
        } else {
            System.out.println("Not a palindrome ❌");
        }

        sc.close();
    }
}