import java.util.Scanner;

public class Pattern15 {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        // Taking input number of lines
        System.out.println("Enter the Number of Lines : ");
        int numberOfLines = scn.nextInt();
        printRightVTypePattern(numberOfLines);
    }
    private static void printRightVTypePattern (int numberOfLines) {
        upperHalfPattern(numberOfLines);
        lowerHalfReversePattern(numberOfLines);
    }
    private static void lowerHalfReversePattern(int numberOfLines) {
        for (int i = numberOfLines - 1; i >= 1; i --) {
            int stars = (numberOfLines - i) + 1;
            int spaces =  2 * (i - 1);
            printSpaces(spaces);
            printStars(stars);
            System.out.println();
        }
    }

    private static void upperHalfPattern(int numberOfLines) {
        for (int i = numberOfLines; i >= 1; i --) {
            int stars = i;
            int spaces = 2 * (numberOfLines - i);
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