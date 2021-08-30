package numbers;
import java.util.Scanner;
public class Main {
    public static boolean even ;
    public static boolean odd;
    public static boolean buzz;
    public static boolean duck;
    public static boolean palindrome;
    public static boolean gapful;
    public static boolean moreThanOne = false;
    public static int times;
    public static String supportedRequest = ("\nSupported requests:\n" +
            "- enter a natural number to know its properties;\n" +
            "- enter two natural numbers to obtain the properties of the list:\n" +
            "  * the first parameter represents a starting number;\n" +
            "  * the second parameters show how many consecutive numbers are to be processed;\n" +
            "- separate the parameters with one space;\n" +
            "- enter 0 to exit.");
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Welcome to Amazing Numbers!\n" + supportedRequest);
        //
        long a = 0;
        userInput(a, times);
    }
    public static void userInput(long a, int times) {
        //Format input
        System.out.println("\nEnter a request:");
        String input = scanner.nextLine();
        if(input.contains(" ")){
            String[] numbers = input.split(" ");
            a =  Long.parseLong(numbers[0]);
            times = Integer.parseInt(numbers[1]);
            moreThanOne = true;
        } else {
            try {
                a = Long.parseLong(input);

            } catch (NumberFormatException e) {
                a = -1;
            }
        }
        if(a<0) {
            System.out.println("The first parameter should be a natural number or zero."); //error message
        }
            fun(a, times);
    }
    public static void fun(long a, int times) { // its the main function but I didnt want it yet there
        while ( a != 0) {
            if (moreThanOne != true && a != 0 && a > 0) {
                checks(a);
            } else if(a == 0) {
                System.out.println("Goodbye!");
            } else if (moreThanOne == true && a != 0 && a > 0) {
                if(times > 0) {
                    doubleChecks(a, times);
                } else {
                    System.out.println("\nThe second parameter should be a natural number.");
                }
            } else {
                System.out.println(supportedRequest);
                userInput(a, times);
            }
            userInput(a, times);
        }
        zeroCase(a);
        minusCase(a);
    }

    public static void checks(long a) {
        if (a > 0) { //all naturel and not negative
            System.out.println("Properties of " + a);
            System.out.println("\teven: " + evenCheck(a));
            System.out.println("\todd: " + oddCheck(a));
            System.out.println("\tbuzz: " + buzzCheck(a));
            System.out.println("\tduck: " + duckCheck(a));
            System.out.println("\tpalindromic: " + palindromicCheck(a));
            System.out.println("\tgapful: "+gapfulCheck(a));
        } else if (a == 0) {
            zeroCase(a);
        } else if(a<0) {
            System.out.println("The first parameter should be a natural number or zero."); //error message
        }
    }
    public static void zeroCase(long a) {
        if (a == 0) {
            System.out.println("Goodbye!");
            System.exit(0);
        }
    }
    public static void minusCase(long a) {

    }

    public static void doubleChecks(long a, long times) {
        int i = 1;
        if (times > 0 && times >= i) {
            for (; i <= times; i++) {
                System.out.println(inLineChecks(a));
                System.out.println();
                a++;
            }
        }
    }
    public static String inLineChecks(long a) {
        return (a + " is " + (buzzCheck(a) ? "buzz " : "")
                + (duckCheck(a) ? "duck " : "")
                + (palindromicCheck(a) ? "palindromic " : "")
                + (gapfulCheck(a) ? "gapful " : "")
                + (evenCheck(a) ? "even " : "")
                + (oddCheck(a) ? "odd " : ""));
    }

    public static boolean evenCheck(long a) {
        if( a % 2 == 0) {
            even = true;
        } else {
            even = false;
        }
        return even;
    }
    public static boolean oddCheck(long a) {
        if( a % 2 != 0) {
            odd = true;
        } else {
            odd = false;
        }
        return odd;
    }
    public static boolean buzzCheck(long a) {
        buzz = false;
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
            duck = true;
        } else {
            duck = false;
        }
        return duck;
    }
    public static boolean palindromicCheck(long a) {
        long copyNumber = a;
        long currentDigit, reversedNumber = 0;
        do{ // what this do is create the reverse number
            currentDigit = copyNumber % 10; //takes remainder
            reversedNumber = (reversedNumber * 10) + currentDigit;
            copyNumber = copyNumber / 10; // making new number
            //I don't fucking get it
        } while (copyNumber != 0);
        //And now we fucking check
        if(a == reversedNumber) {
            palindrome = true;
        } else {
            palindrome = false;
        }
        return palindrome;
    }
    public static boolean gapfulCheck(long number) {
        long firstDigit = number;
        while(firstDigit >= 10) {
            firstDigit = firstDigit /10;
        }
        int lastDigit = (int) (number % 10);
        int length = String.valueOf(number).length();
        if( String.valueOf(number).length() > 2 ) {
            if( number % (firstDigit * 10 + lastDigit * 1) == 0) {
                gapful = true;
            } else {
                gapful = false;
            }
        } else {
            gapful = false;
        }
        return gapful;
    }
}
