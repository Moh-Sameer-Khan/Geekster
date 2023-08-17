import java.util.Scanner;

public class Pattern7 {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        // Taking input number of lines
        System.out.println("Enter the Number of Lines : ");
        int numberOfLines = scn.nextInt();
        printHollowSquarePattern(numberOfLines);
    }
    private static void printHollowSquarePattern(int numberOfLines) {
        for (int i = 1; i <= numberOfLines; i ++) {
           for(int j = 1; j <= numberOfLines; j ++) {
                if(i == 1 || i == numberOfLines || j == 1 || j == numberOfLines) {
                    System.out.print("*   ");
                } else {
                    System.out.print("    ");
                }
           }
           System.out.println();
        }
    }
}