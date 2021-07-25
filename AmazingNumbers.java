import java.util.Scanner;
public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to Amazing Numbers!\n" +
                "\nSupported requests:\n" +
                "- enter a natural number to know its properties;" +
                "\n- enter 0 to exit.");
        System.out.println("\nEnter a request:");
        long a = scanner.nextLong();
        while ( a != 0) {
            if (a > 0) { //all naturel and not negative
                System.out.println("Properties of " + a);
                System.out.println("\teven: " + evenCheck(a));
                System.out.println("\todd: " + oddCheck(a));
                System.out.println("\tbuzz: " + buzzCheck(a));
                System.out.println("\tduck: " + duckCheck(a));
                System.out.println("palindromic: " + palindromicCheck(a));
            } else {
                System.out.println("The first parameter should be a natural number or zero."); //error message
            }
            System.out.print("\nEnter a request:");
            a = scanner.nextLong();
        }
        if( a == 0) {
            System.out.println("Goodbye!");
        }
    }
    public static boolean evenCheck(long a) {
        if( a % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean oddCheck(long a) {
        if( a % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean buzzCheck(long a) {
        boolean buzz = false;
        String reason;
        if( a % 10 == 7 && a % 7 != 0) {
            reason = a + " is ends with 7";
            buzz = true;
        } else if ( a % 7 == 0 && a % 10 != 7) {
            reason = a + " is divisible by 7";
            buzz = true;
        } else if ( a % 7 == 0 && a % 10 == 7) {
            reason = a + "is divisible by 7 and it ends with 7";
            buzz = true;
        } else {
            reason = a + " is neither divisible by 7 nor it ends with 7.";
            buzz = false;
        }
        //reason
        if( buzz == true){
            return true;
        } else {
            return false;
        }
    }
    public static boolean duckCheck(long a) {
        if(String.valueOf(a).contains("0")){
            return true;
        } else {
            return false;
        }
    }
    public static boolean palindromicCheck(long a) {
        long copyNumber = a;
        long currentDigit, reversedNumber = 0;
        do{ // what this do is create the reverse number
            currentDigit = copyNumber % 10; //takes remainder
            reversedNumber = (reversedNumber * 10) + currentDigit;
            copyNumber = copyNumber / 10; // making new number
            //I dont fucking get it
        } while (copyNumber != 0);
        //And now we fucking check
        if(a == reversedNumber) {
            return true;
        } else {
            return false;
        }
    }

}
