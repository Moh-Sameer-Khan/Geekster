import java.util.Scanner;

public class Pattern17 {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        // Taking input number of lines
        // Note : Enter only odds number
        System.out.println("Enter the Number of Lines : ");
        int numberOfLines = scn.nextInt();
        printSquareDiamondSpaceTypePattern (numberOfLines);
    }
    private static void printSquareDiamondSpaceTypePattern (int numberOfLines) {
        upperHalfPattern(numberOfLines);
        middleLineSpacePrint(numberOfLines);
        lowerHalfReversePattern(numberOfLines);
    }
    private static void middleLineSpacePrint(int numberOfLines) {
        for(int i = 1; i <= numberOfLines; i ++) {
            System.out.print("    ");
        }
        System.out.println();
    }
    private static void lowerHalfReversePattern(int numberOfLines) {
        int spaces = numberOfLines - 2;
        for (int i = numberOfLines / 2; i >= 1; i --) {
            int starsLeft = numberOfLines / 2 - (i - 1);
            int starsRight = numberOfLines / 2 - (i - 1);
            printStars(starsLeft);
            printSpaces(spaces);
            printStars(starsRight);
            System.out.println();
            spaces -= 2;
        }
    }

    private static void upperHalfPattern(int numberOfLines) {
        int spaces = 1;
        for (int i = 1; i <= numberOfLines / 2; i ++) {
            int starsLeft = numberOfLines / 2 - (i - 1);
            int starsRight = numberOfLines / 2 - (i - 1);
            printStars(starsLeft);
            printSpaces(spaces);
            printStars(starsRight);
            System.out.println();
            spaces += 2;
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