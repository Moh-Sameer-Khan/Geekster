import java.util.Scanner;

public class Pattern8 {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        // Taking input number of lines
        // Note : Enter only Odds Number as number of Lines
        System.out.println("Enter the Number of Lines : ");
        int numberOfLines = scn.nextInt();
        printXHollowRhombusPattern(numberOfLines);
    }
    private static void printXHollowRhombusPattern(int numberOfLines) {
        for (int i = 1; i <= numberOfLines; i ++) {
           for(int j = 1; j <= numberOfLines; j ++) {
                if(i == j || i + j == numberOfLines + 1) {
                    System.out.print("*   ");
                } else {
                    System.out.print("    ");
                }
           }
           System.out.println();
        }
    }
}