import java.util.Scanner;

public class Pattern14 {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        // Taking input number of lines
        System.out.println("Enter the Number of Lines : ");
        int numberOfLines = scn.nextInt();
        printLeftPyramidPattern(numberOfLines);
    }
    private static void printLeftPyramidPattern (int numberOfLines) {
        upperHalfPattern(numberOfLines);
        lowerHalfReversePattern(numberOfLines);
    }
    private static void lowerHalfReversePattern(int numberOfLines) {
        for (int i = numberOfLines - 1; i >= 1; i --) {
            int stars = i;
            int spaces = numberOfLines - i;
            printSpaces(spaces);
            printStars(stars);
            System.out.println();
        }
    }

    private static void upperHalfPattern(int numberOfLines) {
        for (int i = 1; i <= numberOfLines; i ++) {
            int stars = i;
            int spaces = numberOfLines - i;
            printSpaces(spaces);
            printStars(stars);
            System.out.println();
        }
    }
    private static void printStars(int numberOfStars) {
        for(int i = 1; i <= numberOfStars; i ++) {
            System.out.print("*   "); // total 8 // 1 star and 7 spaces
        }
    }
    private static void printSpaces(int numberOfSpaces) {
        for(int i = 1; i <= numberOfSpaces; i ++) {
            System.out.print("    "); // 4 spaces
        }
    }
}