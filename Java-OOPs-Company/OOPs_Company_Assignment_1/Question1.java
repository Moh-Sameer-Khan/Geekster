import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question1 {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the size of Array : ");
        int n = scn.nextInt();
        
        int [] arr = new int [n];
        inputArray(arr, n);

        List <Integer> result = findSumZeroCombination(arr);

        if(result.size() == 0) {
            System.out.println("No Elements found");
        }else {
            System.out.println("Elements Combinateion whose Sum is 0 : " + result);
        }

    }
    public static List<Integer> findSumZeroCombination(int [] arr) {
        // taking a list bcz output will be less element size  who can size vary
        List<Integer> list = new ArrayList<>();

        int currSum = 0;
        // traversal on the array
        for(int ele : arr) {
            currSum += ele;
            list.add(ele);

            if(currSum == 0) {
                return list;
            }
        }
        // If no combination is found, return an empty list
        return new ArrayList<>();
    }
    public static void inputArray(int [] arr, int n) {
        for(int i = 0; i < n; i ++) {
            arr[i] = scn.nextInt();
        }
    }
}