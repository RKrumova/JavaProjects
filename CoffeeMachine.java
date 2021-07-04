import java.util.Scanner;
public class CoffeeMachine {
    static Scanner scanner = new Scanner (System.in);
    //Default
    public static int water = 400;
    public static int milk = 540;
    public static int beans = 120;
    public static int cups = 9;
    public static int money = 550;
    //Main
    public static void main (String[]args) {
        String action;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            action = scanner.nextLine();
            switch (action) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    refill();
                    break;
                case "take":
                    takeM();
                    break;
                case "remaining":
                    infoMachine();
                    break;
                case "exit":
                    exit();
                    break;
            }
        }while (!action.contains("exit"));
    }
    //Information
    public static void infoMachine() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }
    //Buy
    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String coffeeType = scanner.next();
        switch (coffeeType) {
            case "1":
                espresso();
                break;
            case "2":
                latte();
                break;
            case "3":
                cappucino();
                break;
            case "back":
                break;
            default:
                break;
        }
    }
    //Refill
    public static void refill() {
        System.out.println ("Write how many ml of water do you want to add: ");
        int addWater = scanner.nextInt ();
        water += addWater;
        System.out.println ("Write how many ml of milk do you want to add: ");
        int addMilk = scanner.nextInt ();
        milk += addMilk;
        System.out.println ("Write how many grams of coffee beans do you want to add: ");
        int addBeans = scanner.nextInt ();
        beans += addBeans;
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        int disposable = scanner.nextInt();
        cups += disposable;
    }
    //Take Money
    public static void takeM(){
        System.out.println("I gave you " + money);
        money = 0;
    }
    public static void makeCoffee() {
        System.out.println("Starting to make a coffee\nGrinding coffee beans\nBoiling water\nMixing boiled water with crushed coffee beans\nPouring coffee into the cup\nPouring some milk into the cup\nCoffee is ready!");
    }
    //TYPES OF COFFEE
    public static void espresso() {
        if (water < 250) {
            System.out.println("Sorry, not enough water");
        } else if( beans < 16 ) {
            System.out.println("Sorry, not enough beans");
        } if( cups<1){
            System.out.println("Sorry, not enough cups");
        }
        if (water >= 250 && beans >= 16 && cups >= 1){
            water -= 250;
            beans -= 16;
            money += 4;
            cups -= 1;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }
    public static void latte() {
        if (water < 350) {
            System.out.println("Sorry, not enough water");
        } else if(milk < 75) {
            System.out.println("Sorry, not enough milk");
        } else if( beans < 16 ) {
            System.out.println("Sorry, not enough beans");
        } if( cups<1) {
            System.out.println("Sorry, not enough cups");
        }
        if (water >= 350 && milk >= 75 && beans >= 20 && cups >=1) {
            water -=350;
            milk -=75;
            beans -=20;
            money += 7;
            cups -= 1;
            System.out.println("I have enough resources, making you a coffee!\n");
        }
    }
    public static void cappucino() {
        if (water < 200) {
            System.out.println("Sorry, not enough water\n");
        } else if(milk < 100) {
            System.out.println("Sorry, not enough milk\n");
        } else if( beans < 12 ) {
            System.out.println("Sorry, not enough beans\n");
        } if( cups<1){
            System.out.println("Sorry, not enough cups\n");
        }
        if (water>=200 && milk >= 100 && beans >=12 && cups >= 1) {
            water -= 200;
            milk -= 100;
            beans -= 12;
            money += 6;
            cups -= 1;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }
    //EXIT
    public static void exit(){
        System.exit(0);
    }
}
