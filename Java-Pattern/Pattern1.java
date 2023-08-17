import java.util.Scanner;

public class Pattern1 {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        // Taking input number of lines
        System.out.println("Enter the Number of Lines : ");
        int inputLines = scn.nextInt();
        printSquarePattern(inputLines);
    }
    private static void printSquarePattern(int inputLines) {
        for(int i = 1; i <= inputLines; i ++) {
            printSingleLine(inputLines);
        }
    }
    private static void printSingleLine(int inputLines) {
        for (int i = 1; i <=inputLines; i ++) {
            System.out.print("*    ");
        }
        System.out.println();
    }
}