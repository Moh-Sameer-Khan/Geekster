// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("**************************** Welcome to the Coffee Machine Simulator ***************************");

        CoffeeMachineSimulator coffeeMachineSimulator = new CoffeeMachineSimulator();
        while(true)
        {
            System.out.println("Please Select the option you want");
            System.out.println("1.Make Coffee");
            System.out.println("2.Fill Ingredients");
            System.out.println("3.Take Money");
            System.out.println("4.Ingredients Inventory ");
            System.out.println("5.Show Analytics");
            System.out.println("6.Exit");

            int option = sc.nextInt();

            switch(option)
            {
                case 1 ->  coffeeMachineSimulator.buyCoffee();
                case 2 ->  coffeeMachineSimulator.fillIngredients();
                case 3 ->  coffeeMachineSimulator.takeMoney();
                case 4 ->  coffeeMachineSimulator.ingredientInventory();
                case 5 ->  coffeeMachineSimulator.analytics();
                case 6 -> {
                    System.out.println("Thank you for using the Coffee Machine Simulator!");
                    return;
                }
                default -> System.out.println("Invalid Input");
            }

        }

    }
}