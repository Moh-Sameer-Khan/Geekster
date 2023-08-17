import java.util.Scanner;

public class Pattern2 {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        // Taking input number of lines
        System.out.println("Enter the Number of Lines : ");
        int inputLines = scn.nextInt();
        printPyramidPattern(inputLines);
    }
    private static void printPyramidPattern(int inputLines) {
        for(int i = 1; i <= inputLines; i ++) {
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