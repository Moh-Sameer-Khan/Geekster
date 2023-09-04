import java.util.Scanner;
public class CoffeeMachineSimulator {

    private int milk = 0;
    private int water = 0;
    private int beans = 0;
    private int money = 0;
    private int espressoCount = 0;
    private int latteCount = 0;
    private int cappuccinoCount = 0;
    Scanner sc = new Scanner(System.in);

    public void buyCoffee() throws InterruptedException {
        System.out.println("Enter the number corresponding to the coffee you want to buy:");
        System.out.println("1:Espresso ($" + Espresso.getEspressoPrice() + ")");
        System.out.println("2:Latte ($" + Latte.getLattePrice()+ ")");
        System.out.println("3:Cappuccino ($" + Cappuccino.getCappuccinoPrice() + ")") ;
        int choice = sc.nextInt();


        switch (choice) {
            case 1 -> {
                if (hasIngredients(Espresso.getEspressoMilk(), Espresso.getEspressoWater(), Espresso.getEspressoBean())) {
                    System.out.println("Preparing Espresso...");
                    Thread.sleep(2000); // Sleep for 2 seconds during preparation
                    makeCoffee(Espresso.getEspressoMilk(), Espresso.getEspressoWater(), Espresso.getEspressoBean(), Espresso.getEspressoPrice());
                    espressoCount++;
                    System.out.println("Espresso is prepared and ready to serve.");
                } else {
                    System.out.println("Not Enough Ingredients for Espresso");
                }
            }
            case 2 -> {
                if (hasIngredients(Latte.getLatteMilk(), Latte.getLatteWater(), Latte.getLatteBean())) {
                    System.out.println("Preparing Latte...");
                    Thread.sleep(2000); // Sleep for 2 seconds during preparation
                    makeCoffee(Latte.getLatteMilk(), Latte.getLatteWater(), Latte.getLatteBean(), Latte.getLattePrice());
                    latteCount++;
                    System.out.println("Latte is prepared and ready to serve.");
                } else {
                    System.out.println("Not Enough Ingredients for Latte");
                }
            }
            case 3 -> {
                if (hasIngredients(Cappuccino.getCappuccinoMilk(), Cappuccino.getCappuccinoWater(), Cappuccino.getCappuccinoBean())) {
                    System.out.println("Preparing Cappuccino...");
                    Thread.sleep(2000); // Sleep for 2 seconds during preparation
                    makeCoffee(Cappuccino.getCappuccinoMilk(), Cappuccino.getCappuccinoWater(), Cappuccino.getCappuccinoBean(), Cappuccino.getCappuccinoPrice());
                    cappuccinoCount++;
                    System.out.println("Cappuccino is prepared and ready to serve.");
                } else {
                    System.out.println("Not Enough Ingredients for Cappuccino");
                }
            }
            default -> System.out.println("Invalid Coffee Choice");
        }

    }


    private void makeCoffee(int coffeeMilk, int coffeeWater, int coffeeBean, int coffeePrice) {
        money+=coffeePrice;
        water-=coffeeWater;
        milk-=coffeeMilk;
        beans-=coffeeBean;
    }

    private boolean hasIngredients(int coffeeMilk, int coffeeWater, int coffeeBean) {
        return milk>=coffeeMilk && coffeeWater<=water && coffeeBean<=beans;
    }
    public void fillIngredients()
    {

        while(true)
        {
            System.out.println("Enter the number corresponding to the Ingredient you want to fill:");
            System.out.println("1.Milk");
            System.out.println("2.Water");
            System.out.println("3.Beans");
            System.out.println("4.Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the quantity of Milk to fill: ");
                    this.milk += sc.nextInt();
                    System.out.println("Milk has been filled.");
                }
                case 2 -> {
                    System.out.print("Enter the quantity of Water to fill: ");
                    this.water += sc.nextInt();
                    System.out.println("Water has been filled.");
                }
                case 3 -> {
                    System.out.print("Enter the quantity of Beans to fill: ");
                    this.beans += sc.nextInt();
                    System.out.println("Beans have been filled.");
                }
                case 4 -> {
                    System.out.println("Exiting the ingredient selection menu.");
                    return;
                }
                default -> System.out.println("Invalid choice. Please select a valid option.");
            }
        }


    }

    public void ingredientInventory() {
        System.out.println("Current Ingredient Inventory:");
        System.out.println("Milk: " + milk);
        System.out.println("Water: " + water);
        System.out.println("Beans: " + beans);
    }
    public void takeMoney(){
        System.out.println("Amount of $" + money + " has been withdrawn from the coffee machine.");
        money = 0;
    }
    public void analytics() {
        System.out.println("Analytics:");
        System.out.println("Milk used: " + milk + " units");
        System.out.println("Water used: " + water + " units");
        System.out.println("Beans used: " + beans + " units");
        System.out.println("Money collected: $" + money);
        System.out.println("Espresso coffees made: " + espressoCount);
        System.out.println("Latte coffees made: " + latteCount);
        System.out.println("Cappuccino coffees made: " + cappuccinoCount);

        int totalCoffeesMade = espressoCount + latteCount + cappuccinoCount;
        System.out.println("Total coffees made: " + totalCoffeesMade);

        if (espressoCount > 0) {
            int espressoMoney = espressoCount * Espresso.getEspressoPrice();
            System.out.println("Total money from Espresso: $" + espressoMoney);
        }

        if (latteCount > 0) {
            int latteMoney = latteCount * Latte.getLattePrice();
            System.out.println("Total money from Latte: $" + latteMoney);
        }

        if (cappuccinoCount > 0) {
            int cappuccinoMoney = cappuccinoCount * Cappuccino.getCappuccinoPrice();
            System.out.println("Total money from Cappuccino: $" + cappuccinoMoney);
        }
    }
}
