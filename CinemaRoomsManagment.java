//package cinema;
import java.util.Scanner;
import java.util.Arrays;
//Five phase
public class Cinema {
    public static int rows;
    public static int seatsAtRow;
    public static int soldTickets = 0;
    public static int currentIncome = 0;

    public static char[][]cinemaSeat ;
    public static boolean newRoom = true;
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        createGrid();
        int option = 5; //random number so it does scream mistake
        do{
            System.out.println("\n1. Show the seats\n2. Buy a ticket"
                    + "\n3.Statistics\n0. Exit");
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
                case 3:
                    statistics(soldTickets, rows, seatsAtRow, currentIncome);
                    break;
                default:
                    System.out.println("Try agains");
                    break;
            }
        }while (option != 0);
    }
    //Creating
    public static void createGrid(){
        System.out.println("\nEnter the number of rows:");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seatsAtRow = scanner.nextInt();
        cinemaSeat = new char[rows][seatsAtRow]; // seating
        //creating the two dimensional array for  the Cinema seatings
        if(newRoom == true) {
            for (int a = 0; a < rows; a++) {
                for (int b = 0; b < seatsAtRow; b++) {
                    cinemaSeat[a][b] = 'S';
                }
            }
            newRoom = false;
            newRoom = false;
        }
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
                }
            } else {
                ticket = 10;
            }
            System.out.println("Ticket price: $" + ticket);
            soldTickets++;
            currentIncome += ticket;
        } else {
            System.out.println("That ticket has already been purchased!\n");
        }
    }
    //calculate the statistics
    public static void statistics(int soldTickets, int rows, int seatsAtRow, int currentIncome){
        //number purchased tickets
        System.out.println("Number of purchased tickets: " + soldTickets);
        double dPercentage = (soldTickets * 100 / (rows * seatsAtRow));
        System.out.println("Percentage: " +  + "%");
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncomeFunction(rows, seatsAtRow));
    }
    public static int totalIncomeFunction(int rows, int seatsAtRow){
        int totalIncome;
        if( rows * seatsAtRow <= 60 ) {
            totalIncome = rows * seatsAtRow * 10;
        } else {
            if(rows % 2 == 0) { // even
                totalIncome = (rows * seatsAtRow / 2) * 10 + (rows * seatsAtRow / 2) * 8;
            } else {
                totalIncome = seatsAtRow * (rows - 1)/2 * 10 + seatsAtRow * (rows + 1)/2 * 8;
            }
        }
        return totalIncome;
    }
    public static void exit(){
        System.exit(0);
    }
}//Favourite flower the rose;
