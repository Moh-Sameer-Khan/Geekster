import java.util.Scanner;

public class Pattern10 {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        // Taking input number of lines
        System.out.println("Enter the Number of Lines : ");
        int numberOfLines = scn.nextInt();
        printReverseTriangelPattern(numberOfLines);
    }
    private static void printReverseTriangelPattern (int numberOfLines) {
        for (int i = numberOfLines; i >= 1; i --) {
            int stars = 2 * (i - 1) + 1;
            int spaces = numberOfLines - i;
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