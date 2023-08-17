import java.util.Scanner;

public class Pattern6 {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        // Taking input number of lines
        System.out.println("Enter the Number of Lines : ");
        int numberOfLines = scn.nextInt();
        printReverseRightAlignedTrianglePattern(numberOfLines);
    }
    private static void printReverseRightAlignedTrianglePattern(int numberOfLines) {
        for (int i = numberOfLines; i >= 1; i --) {
            int stars = i;
            int spaces = (numberOfLines - i) * 2;
            printSpaces(spaces);
            printStars(stars);
            System.out.println();
        }
    }
    private static void printStars(int numberOfStars) {
        for(int i = 1; i <= numberOfStars; i ++) {
            System.out.print("*   ");
        }
    }
    private static void printSpaces(int numberOfSpaces) {
        for(int i = 1; i <= numberOfSpaces; i ++) {
            System.out.print("    ");
        }
    }
}