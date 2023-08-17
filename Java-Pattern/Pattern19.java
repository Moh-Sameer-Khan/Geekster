import java.util.Scanner;

public class Pattern19 {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        // Taking input number of lines
        // Note : Enter only odds number
        System.out.println("Enter the Number of Lines : ");
        int numberOfLines = scn.nextInt();
        printSquareDiamondBlankTypePattern (numberOfLines);
    }
    private static void printSquareDiamondBlankTypePattern (int numberOfLines) {
        upperHalfPattern(numberOfLines);
        // middleLineSpacePrint(numberOfLines);
        // lowerHalfReversePattern(numberOfLines);
    }
    // private static void middleLineSpacePrint(int numberOfLines) {
    //     for(int i = 1; i <= numberOfLines; i ++) {
    //         System.out.print("    ");
    //     }
    //     System.out.println();
    // }
    private static void lowerHalfReversePattern(int numberOfLines) {
        int spaces = numberOfLines - 2;
        for (int i = numberOfLines / 2; i >= 1; i --) {
            int starsLeft = numberOfLines / 2 - (i - 2);
            int starsRight = numberOfLines / 2 - (i - 1);
            printStars(starsLeft);
            printSpaces(spaces);
            printStars(starsRight);
            System.out.println();
            spaces -= 2;
        }
    }

    //logic to print the first half pattern 
    private static void upperHalfPattern(int numberOfLines) {
        // Left Star print
        for (int i = 1; i <= numberOfLines; i ++) {
            for(int j = 1; j <= numberOfLines - i + 1; j ++) {
                System.out.print("*");
            }
            // Loop Calculating the spaces
            for(int j = 1; j <= 2 * i - 2; j ++) {
                System.out.print(" ");
            }

            // Right star print
            for(int j = 1; j <= numberOfLines - i + 1; j ++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=numberOfLines - 1; i>=1; i--)  
{  
for(int j=i; j<=numberOfLines; j++)  
{  
System.out.print("*");  
}   
//loop calculates space  
for(int k=1; k<=(2*i)-2; k++)  
{  
System.out.print(" ");  
}   
for(int j=i; j<= numberOfLines; j++)  
{  
System.out.print("*");  
}   
System.out.println();  
}   






        // for (int i = 1; i <= numberOfLines / 2 + 1; i ++) {
        //     int stars = numberOfLines - ;
        //     int spaces = i;
        //     // int starsRight = numberOfLines / 2 - (i - 1);
        //     printStars(stars);            

        //     printSpaces(spaces);
        //     // printStars(starsRight);
        //     for(int j = 1; j <= numberOfLines / 2 - i + 2; j ++) {
        //         if(i == 1 && j == 1) {
        //             continue;
        //         }
        //         System.out.print("*   ");
        //     }
        //     System.out.println();
        //     // spaces += 2;
        // }
    }
    private static void printStars(int numberOfStars) {
        for(int i = 1; i <= numberOfStars / 2 - i + 2; i ++) {
            System.out.print("*   "); // total 8 // 1 star and 7 spaces
        }
    }
    private static void printSpaces(int numberOfSpaces) {
        for(int i = 1; i <= numberOfSpaces * 2 - 3; i ++) {
            System.out.print("    "); // 4 spaces
        }
    }
}