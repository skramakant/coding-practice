package interviews;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromeGenerator {
    // Function to generate all permutations of the input string
    private static void permute(char[] chars, int l, int r, Set<String> permutations) {
        if (l == r) {
            permutations.add(new String(chars));
        } else {
            for (int i = l; i <= r; i++) {
                swap(chars, l, i);
                permute(chars, l + 1, r, permutations);
                swap(chars, l, i); // backtrack
            }
        }
    }

    // Utility function to swap two characters in an array
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    // Function to check if a string is a palindrome
    private static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Main function to generate all possible palindromic strings of the input length
    public static List<String> generatePalindromes(String input) {
        Set<String> permutations = new HashSet<>();
        permute(input.toCharArray(), 0, input.length() - 1, permutations);

        List<String> palindromes = new ArrayList<>();
        for (String perm : permutations) {
            if (isPalindrome(perm)) {
                palindromes.add(perm);
            }
        }

        return palindromes;
    }
}
