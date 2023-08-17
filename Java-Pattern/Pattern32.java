import java.util.Scanner;

import javax.print.attribute.standard.PrinterName;

public class Pattern32 {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        // Taking input number of lines
        // Note : It can be solverd using methods
        System.out.println("Enter the Number of Lines : ");
        int numberOfLines = scn.nextInt();
        printPattern (numberOfLines);
    }
    private static void printPattern(int numberOfLines) {

        // initilize printnumber, totalch, stars
        int stars = 1;
        int totalch = (2 * numberOfLines) - 1;
        int printNum = 1;

// Method -- 1 ***************************************************

        // traversal for lines
        for(int i = 1; i <= totalch; i ++) {

            // traversal for printing the numbers and stars where even 
            for (int j = 1; j <= stars; j ++) {
                // now we want same line print like a/o Pattern increasing this loop print like that and print * where i  == j bcz loop is reverse otherswise i +j = n + 1
                    if(j % 2 == 0) {
                        System.out.print("*\t");
                    }else {
                        System.out.print(printNum + "\t");
                    }
            }
            System.out.println();
            
            if (i < numberOfLines) {
                printNum ++;
                stars += 2;
            } else {
                printNum --;
                stars -= 2;
            } 
        }


        // Method -- 2 *************************************** Basic and reverse after half complete

        // Uppper Half pattern
        // for(int i = 1; i <= numberOfLines; i ++) {
        //     for(int j = 1; j <= stars; j ++) {
        //         if(j % 2 == 0) {
        //             System.out.print("*\t");
        //         }else {
        //             System.out.print(printNum + "\t");
        //         }
        //     }
        //     if(i < numberOfLines) {
        //         printNum ++;
        //         stars += 2;
        //     }
        //     System.out.println();
        // }
        
        // // just for helping the findout printnum and stars
        // // System.out.println(printNum);
        // // System.out.println(stars);

        // printNum --;
        // stars -= 2;

        // // Lower Half Pattern
        // for(int i = numberOfLines - 1; i >= 1; i --) {
            
        //     for(int j = 1; j <= stars; j ++) {
        //         if(j % 2 == 0) {
        //             System.out.print("*\t");
        //         }else {
        //             System.out.print(printNum + "\t");
        //         }
        //     }
        //     if(i < numberOfLines) {
        //         printNum --;
        //         stars -= 2;
        //     }
        //     System.out.println();
        // }
    }
}
