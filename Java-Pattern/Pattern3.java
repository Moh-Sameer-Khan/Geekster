import java.util.Scanner;

public class Pattern3 {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        // Taking input number of lines
        System.out.println("Enter the Number of Lines : ");
        int inputLines = scn.nextInt();
        printReversePyramidPattern(inputLines);
    }
    private static void printReversePyramidPattern(int inputLines) {
        for(int i = inputLines; i >= 1; i --) {
            printSingleLine(i);
        }
    }
    private static void printSingleLine(int inputLines) {
        for (int i = 1; i <=inputLines; i ++) {
            System.out.print("*    ");
        }
        System.out.println();
    }
}