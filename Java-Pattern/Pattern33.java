import java.util.Scanner;

public class Pattern33 {
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
        int numberOfStars = 1;
        int printNum = numberOfLines;
        int zeroPosition = 1; // bcz always same position and we will increment this by one

        // traversal for lines
        for(int i = 1; i <= numberOfLines; i ++) {

            // traversal for spacesa print bcz first space printing
            for(int j = 1; j <= numberOfSpaces; j ++) {
                System.out.print("   ");
            }
            
            int printValue = printNum;
            // System.out.println(printValue); // just confirming
            // traversal for printing the stars
            for (int j = 1; j <= numberOfStars; j ++) {
                // for zero position
                if(zeroPosition == j) {
                    System.out.print("0  ");
                }else {
                    System.out.print(printValue + "  ");
                }
                
                
                // bcz after half its again decreasing order so create that part
                if(j <= numberOfStars / 2) {
                    printValue ++;
                } else {
                    printValue --;
                }
                
            }
            System.out.println();

            // increasing the number of stars and number of spaces a/o pattern need
            numberOfSpaces --;
            numberOfStars += 2;
            zeroPosition ++; // or we can solve by another variable can take on loop x = printNum then print X and printNum ++;
            printNum --;
        }
    }
}
