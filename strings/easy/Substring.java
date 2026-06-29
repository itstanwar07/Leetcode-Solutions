/*
 * Problem: Number of Strings That Appear as Substrings in Word
 * Approach:
 * - Traverse each string in the patterns array.
 * - Use indexOf() to check if it exists in the given word.
 * - Increment the count for every matching substring.
 * - Return the final count.
 */


import java.util.Scanner;

public class Substring {

    // Function to count how many patterns are substrings of the given word
    public static int numOfStrings(String[] patterns, String word) {
        int count = 0;

        for (String pattern : patterns) {
            if (word.indexOf(pattern) != -1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of patterns
        System.out.print("Enter number of patterns: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        // Read patterns
        String[] patterns = new String[n];
        System.out.println("Enter the patterns:");
        for (int i = 0; i < n; i++) {
            patterns[i] = sc.nextLine();
        }

        // Read the word
        System.out.print("Enter the word: ");
        String word = sc.nextLine();

        // Display result
        int result = numOfStrings(patterns, word);
        System.out.println("Number of matching patterns: " + result);

        sc.close();
    }
}