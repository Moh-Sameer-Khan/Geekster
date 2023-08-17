import java.util.Scanner;

public class Pattern29 {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        // Taking input number of lines
        // Note : It can be solverd using methods
        System.out.println("Enter the Number of Lines : ");
        int numberOfLines = scn.nextInt();
        printPattern (numberOfLines);
    }
    private static void printPattern(int numberOfLines) {
        
          // creating logic for space and stars
        int numberOfSpaces = numberOfLines - 1;
        int numberPrint = 1;
        int printNum = 1;
        // traversal for lines
        for(int i = 1; i <= numberOfLines; i ++) {

            // traversal for spacesa print bcz first space printing
            for(int j = 1; j <= numberOfSpaces; j ++) {
                System.out.print("\t");
            }
            
            // traversal for printing the stars
            for (int j = 1; j <= numberPrint; j ++) {
                
                // when j == 1 || j == printnum then print number bcz always j == 1 || j == printum mean end will be nubmer
                if(j == 1 || j == numberPrint) {
                    System.out.print(printNum + "\t");
                } else {
                    System.out.print("0\t");
                }
                
            }
            System.out.println();

            // increasing the number of stars and number of spaces a/o pattern need
            numberOfSpaces --;
            numberPrint += 2;
            printNum ++; // or we can solve by another variable can take on loop x = printNum then print X and printNum ++;
            
        }
    }
}
