package numbers;
import java.util.Scanner;
public class Main {

    public static boolean buzz;
    public static boolean duck;
    public static boolean palindrome;
    public static boolean gapful;
    public static boolean spy;
    public static boolean even ;
    public static boolean odd;
    public static boolean moreThanOne = false;
    public static boolean properaty = false;
    public static int times;
    public static String properatyToCheck = null;
    public static String supportedRequest = ("Supported requests:\n" +
            "- enter a natural number to know its properties;\n" +
            "- enter two natural numbers to obtain the properties of the list:\n" +
            "  * the first parameter represents a starting number;\n" +
            "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
            "- two natural numbers and a property to search for;\n" +
            "- separate the parameters with one space;\n" +
            "- enter 0 to exit.");
    public static String[] errorMessage = new String[]{"The first parameter should be a natural number or zero",
        "The second parameter should be a natural number.\n",
        "The property " + properatyToCheck +" is wrong.\nAvailable properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY]"};
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Welcome to Amazing Numbers!\n" + supportedRequest);
        long a = 0;
        userInput(a, times, properatyToCheck);
    }
    public static void userInput(long a, int times, String properatyToCheck) {
        //Format input
        System.out.println("\nEnter a request:");
        String input = scanner.nextLine();
        if(input.contains(" ")){
            String[] numbers = input.split(" ");
            a =  Long.parseLong(numbers[0]);
            times = Integer.parseInt(numbers[1]);
            moreThanOne = true;
            if(numbers.length < 2) {
                properaty = true;
                properatyToCheck = numbers[2];
            }
        } else {
            try {
                a = Long.parseLong(input);
            } catch (NumberFormatException e) {
                a = -1;
            }
        }
        if(a<0) {
            System.out.println(errorMessage[0]);
        }
        fun(a, times, properatyToCheck);
    }
    public static void fun(long a, int times, String properatyToCheck) { // its the main function but I didnt want it yet there
        while ( a != 0) {
            if (moreThanOne != true && a != 0 && a > 0) {
                checks(a);
            } else if(a == 0) {
                System.out.println("Goodbye!");
            } else if (moreThanOne == true && a != 0 && a > 0) {
                if(times > 0 ) {
                    if(properaty == false) {
                        doubleChecks(a, times);
                    } else {
                        notSingleCheck(a, times, properatyToCheck);
                    }
                } else {
                    System.out.println(errorMessage[1]);
                }
            } else {
                System.out.println(supportedRequest);
                userInput(a, times, properatyToCheck);
            }
            userInput(a, times, properatyToCheck);
        }
        zeroCase(a);
    }
    public static void zeroCase(long a) {
        if (a == 0) {
            System.out.println("Goodbye!");
            System.exit(0);
        }
    }
    public static void checks(long a) {
        if (a > 0) { //all naturel and not negative
            System.out.println("Properties of " + a);
            System.out.println("\tbuzz: " + buzzCheck(a));
            System.out.println("\tduck: " + duckCheck(a));
            System.out.println("\tpalindromic: " + palindromicCheck(a));
            System.out.println("\tgapful: "+gapfulCheck(a));
            System.out.println("\tspy: " + spyCheck(a));
            System.out.println("\teven: " + evenCheck(a));
            System.out.println("\todd: " + oddCheck(a));
        } else if (a == 0) {
            zeroCase(a);
        } else if(a<0) {
            System.out.println(errorMessage[0]); //error message
        }
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
                + (spyCheck(a) ? "spy " : "")
                + (evenCheck(a) ? "even " : "")
                + (oddCheck(a) ? "odd " : ""));
    }
    public static void notSingleCheck(long a, int times, String properatyToCheck) {
        StringBuilder result = new StringBuilder();
        result.append(a + " is ");
        switch(properatyToCheck) {
            case "":
            case "buzz":
            case "BUZZ":
                result.append(buzzCheck(a) ? "buzz " : "");
            case "duck":
            case "DUCK":
                result.append(duckCheck(a) ? "duck " : "");
            case "palindromic":
            case "PALINDROMIC":
                result.append(palindromicCheck(a) ? "palindromic " : "");
            case "GAPFUL":
            case "gapful" :
                result.append(gapfulCheck(a) ? "gapful " : "");
            case "SPY":
            case "spy":
                result.append(spyCheck(a) ? "spy " : "");
            case "EVEN":
            case "even":
                result.append(evenCheck(a) ? "even " : "");
            case "ODD":
            case "odd":
                result.append(oddCheck(a) ? "odd ": "");
                break;
            default:
                result.append(errorMessage[3]);
                break;
        }
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
    //
    public static boolean spyCheck(long a) {
        long spyNumber = 0;
        String aa = String.valueOf(a);
        String[] aString = aa.split("");
        for (int i  = 0; i < aString.length; i++) {
            spyNumber += Long.parseLong(aString[i]);
        }
        if(spyNumber == a) {
            spy = true;
        } else {
            spy = false;
        }
        return spy;
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
}
