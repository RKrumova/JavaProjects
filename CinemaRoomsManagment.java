import java.util.Scanner;
import java.util.Arrays;
//Four phase
public class Cinema {
    public static int rows;
    public static int seatsAtRow;
    public static char[][]cinemaSeat ;
    public static boolean newRoom = true;
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        createGrid();
        chooseYourFunction();
    }
     public static void createGrid(){
         System.out.println("\nEnter the number of rows:");
         rows = scanner.nextInt();
         System.out.println("Enter the number of seats in each row:");
         seatsAtRow = scanner.nextInt();
         cinemaSeat = new char[rows][seatsAtRow]; // seating
         //creating the two dimentional array for  the Cinema seatings
         if(newRoom == true) {
             for (int a = 0; a < rows; a++) {
                 for (int b = 0; b < seatsAtRow; b++) {
                     cinemaSeat[a][b] = 'S';
                 }
             }
             newRoom = false;
         }
     }
    //choose what to do
    public static void chooseYourFunction(){
        int option = 5; //random number so it does scream mistake
        do{
            System.out.println("\n1. Show the seats\n2. Buy a ticket\n0. Exit");
            option = scanner.nextInt();
            switch (option) {
                case 0:
                    exit();
                    break;
                case 1:
                    cinemaGrid(rows, seatsAtRow);
                    break;
                case 2:
                    buyTicket(cinemaSeat);
                    break;
                default:
                    System.out.println("Try agains");
                    break;
            }
        }while (option != 0);
    }
    //this prints the matrix
    public static void cinemaGrid(int rows, int seatsAtRow) {
        System.out.print("Cinema:\n ");
        //that prints the numbers in a row
        for(int a = 1; a <= seatsAtRow; a++){
            System.out.print(" " + a);
        }
        for (int a = 0; a < rows; a++) {
            System.out.print("\n" + (a + 1));
            for (int b = 0; b < seatsAtRow; b++) {
                System.out.print(" " + cinemaSeat[a][b]);
            }
        }
    }
    //buying Ticket
    public static void buyTicket(char[][] cinemaSeat){
        int ticket;
        System.out.println("\nEnter a row number: ");
        int buyInRow = scanner.nextInt() - 1;
        System.out.println("Enter a seat number in that row:");
        int buySeatInRow = scanner.nextInt() - 1;
        if(cinemaSeat[buyInRow][buySeatInRow] != 'B') {
            cinemaSeat[buyInRow][buySeatInRow] = 'B';
            if( rows * seatsAtRow >= 60 ) {
                if (rows % 2 == 0) {
                    if (rows / 2 > buyInRow) {
                        //first half
                        ticket = 10;
                    } else {
                        //second half
                        ticket = 8;
                    }
                } else {
                    // if its uneven number 1,3....9, 23...etc
                    if ((rows - 1) / 2 > buyInRow) {
                        //first half
                        ticket = 10;
                    } else {
                        //second half
                        ticket = 8;
                    }
                } }
            else {
                ticket = 10;
            }
            System.out.println("Ticket price: $" + ticket);
        }
    }
    public static void exit(){
        System.exit(0);
    }
}//Favourite flower the rose;
