import java.util.Scanner;

public class Pattern30 {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        // Taking input number of lines
        // Note : It can be solverd using methods
        System.out.println("Enter the Number of Lines : ");
        int numberOfLines = scn.nextInt();
        printPattern (numberOfLines);
    }
    private static void printPattern(int numberOfLines) {

        // traversal for lines
        for(int i = 1; i <= numberOfLines; i ++) {

            // for intializng the print a/o pattern
            
            // traversal for printing the numbers
            for (int j = numberOfLines; j >= 1; j --) {
                // now we want same line print like a/o j increasing this loop print like that
                
                System.out.print(j + "\t");
            }
            System.out.println();
        }
    }
}
