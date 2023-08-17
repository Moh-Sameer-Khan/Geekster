import java.util.Scanner;

public class Pattern16 {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        // Taking input number of lines
        System.out.println("Enter the Number of Lines : ");
        int numberOfLines = scn.nextInt();
        printLeftVTypePattern (numberOfLines);
    }
    private static void printLeftVTypePattern (int numberOfLines) {
        upperHalfPattern(numberOfLines);
        lowerHalfReversePattern(numberOfLines);
    }
    private static void lowerHalfReversePattern(int numberOfLines) {
        for (int i = 1; i <= numberOfLines - 1; i ++) {
            int stars = i + 1;
            int spaces = i + 1; // Doubt here not sure
            printSpaces(spaces);
            printStars(stars);
            System.out.println();
        }
    }

    private static void upperHalfPattern(int numberOfLines) {
        for (int i = numberOfLines; i >= 1; i --) {
            int stars = i;
            int spaces = i;
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