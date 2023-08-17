import java.util.Scanner;

public class Pattern28 {
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
        int printNum = 1;
        // traversal for lines
        for(int i = 1; i <= numberOfLines; i ++) {

            // traversal for spacesa print bcz first space printing
            for(int j = 1; j <= numberOfSpaces; j ++) {
                System.out.print("\t");
            }
            // for intializng the print a/o pattern
            
            // traversal for printing the stars
            for (int j = 1; j <= numberOfStars; j ++) {
                // now we want same line print like a/o j increasing this loop print like that
                
                System.out.print(printNum + "\t");
                
                // bcz after half its againg decreasing order so create that part
                if(j <= numberOfStars / 2) {
                    printNum ++;
                } else {
                    printNum --;
                }
                
            }
            System.out.println();

            // increasing the number of stars and number of spaces a/o pattern need
            numberOfSpaces --;
            numberOfStars += 2;
            printNum += 2; // or we can solve by another variable can take on loop x = printNum then print X and printNum ++;
            
        }
    }
}
