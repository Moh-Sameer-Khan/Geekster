import java.util.Scanner;

public class Pattern18 {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        // Taking input number of lines
        // Note : It can be odd or even
        System.out.println("Enter the Number of Lines : ");
        int numberOfLines = scn.nextInt();
        printDiamondStarTypePattern (numberOfLines);
    }
    private static void printDiamondStarTypePattern (int numberOfLines) {
        upperHalfPattern(numberOfLines);
        lowerHalfReversePattern(numberOfLines);
    }
    private static void lowerHalfReversePattern(int numberOfLines) {
        // int spaces = 1; // or we can manulally increase spaces
        for (int i = numberOfLines / 2; i >= 1; i --) {
            int stars = 2 * (i - 1) + 1; 
            int spaces = numberOfLines / 2 - i + 1; // or we can by logic increase spaces
            printSpaces(spaces);
            printStars(stars);
            System.out.println();
            // spaces ++;
        }
    }

    private static void upperHalfPattern(int numberOfLines) {
        for (int i = 1; i <= numberOfLines / 2 + 1; i ++) {
            int stars = 2 * (i - 1) + 1;
            int spaces = numberOfLines / 2 - i + 1;
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