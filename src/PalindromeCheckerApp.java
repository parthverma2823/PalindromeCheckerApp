import java.util.Stack;

public class PalindromeCheckerUC5 {

    public static void main(String[] args) {

        // Original string
        String word = "madam";

        // Create a stack to store characters
        Stack<Character> stack = new Stack<>();

        // Push characters into the stack
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        boolean isPalindrome = true;

        // Pop characters and compare with original string
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        // Print result
        if (isPalindrome) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}
