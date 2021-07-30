package numbers;
import java.util.Arrays;
import java.util.Scanner;
public class AmazingNumbers {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String supportedRequest = ("\nSupported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameters show how many consecutive numbers are to be processed;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");
        System.out.println("Welcome to Amazing Numbers!\n" + supportedRequest);
        System.out.println("\nEnter a request:");
        long a = scanner.nextLong();
        while ( a != 0) {
            if (scanner.hasNextLong() && a != 0) {
                int times = scanner.nextInt(); // times
                if( !scanner.hasNextInt()) {
                    checks(a);
                } else {
                    for(int i = 1; i <=  times; i++) {
                        checks(a);
                        a += 1;
                    }
                }
            } else if(a == 0) {
                System.out.println("Goodbye!");
            } else {
                System.out.println(supportedRequest);
            }
        }
        if (a == 0) {
            System.out.println("Goodbye!");
            return;
        }
    }
    public static void checks(long a) {
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
    public static boolean gapful(long number) {
        long firstDigit = number;
        while(firstDigit >= 10) {
            firstDigit = firstDigit /10;
        }
        int lastDigit = (int) (number % 10);
        int length = String.valueOf(number).length();
        if( String.valueOf(number).length() > 2 ) {
            if( number % (firstDigit * 10 + lastDigit * 1) == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
        //check if it has more than tree digits

    }
}
// I like this project it teach me stuff
