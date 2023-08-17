import java.util.Scanner;

public class Pattern12 {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        // Taking input number of lines
        System.out.println("Enter the Number of Lines : ");
        int numberOfLines = scn.nextInt();
        printTriangleImperativeSymbolPattern(numberOfLines);
    }
    private static void printTriangleImperativeSymbolPattern (int numberOfLines) {
        for (int i = 1; i <= numberOfLines; i ++) {
            int stars = 2 * i;
            int spaces = numberOfLines - i;
            printSpaces(spaces);
            printStars(stars);
            System.out.println();
        }
    }
    private static void printStars(int numberOfStars) {
        for(int i = 1; i < numberOfStars; i ++) {
            if(i % 2 == 1) {
                System.out.print("*   "); // total 8 // 1 star and 7 spaces
            } else {
                System.out.print("!   "); // total 8 // 1 star and 7 spaces
            }
        }
    }
    private static void printSpaces(int numberOfSpaces) {
        for(int i = 1; i <= numberOfSpaces; i ++) {
            System.out.print("    "); // 4 spaces
        }
    }
}