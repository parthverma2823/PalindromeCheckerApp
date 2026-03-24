import java.util.Scanner;

public class PalindromeCheckerApp {

    public static boolean isPalindrome(String str) {

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Step 1: Normalize string
        input = input.replaceAll("\\s+", "").toLowerCase();

        // Step 2: Check palindrome
        boolean result = isPalindrome(input);

        if (result) {
            System.out.println("It is a palindrome ✅");
        } else {
            System.out.println("Not a palindrome ❌");
        }

        sc.close();
    }
}