import java.util.Scanner;

public class Pattern5 {
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
            int spaces = numberOfLines - i; 
            printSpaces(spaces);
            printStars(stars);
            System.out.println();
        }
    }
    private static void printStars(int stars) {
        for(int i = 1; i <= stars; i ++) {
            System.out.print("*   ");
        }
    }
    private static void printSpaces(int spaces) {
        for(int i = 1; i <= spaces; i ++) {
            System.out.print("    ");
        }
    }
}