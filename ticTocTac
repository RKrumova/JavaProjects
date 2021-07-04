//package tictactoe;
import java.util.Scanner;
import java.util.Arrays;
public class TikTacToe {
    public static Scanner scanner = new Scanner (System.in);
    //variables
     static String[][] moves = new String[3][3];
     static boolean emty = false;//for not
     static boolean xwins = false;
     static boolean owins = false;
     static boolean impossible = false;

    public static void main(String[] args) {
        System.out.print("Enter cells:");
        gameGrid();
        wins();
        gameResult();
    }
    //finished
    public static void gameGrid () {
        String icells = scanner.nextLine();
        String[] cells = icells.split(""); // 9 index
        //into the 2D array
        for(int i = 0, m = 0, n = 0; i < 9; i++){
            //first correct i=4, i =8
            if( m < 3 ) { //rows
                if( n < 3){ //number
                    moves[m][n] = cells[i];
                    n++;
                    if( n > 2){
                        n = 0;
                        ++m;
                    }
                }
            }
        }
        //grid
        System.out.println("\n");
        System.out.print("---------\n");
        for(int i = 0; i < 9; i++) {
            String start = "";
            String end = "";
            if(i == 0 || i == 3 ||  i == 6){
                start = "| ";
            }
            if( i == 2 || i == 5 || i == 8){
                end = "|\n";
            }
            System.out.print(start + cells[i] + " " + end);
        }
        System.out.println("---------");
        if(icells.contains("_")){
            emty = true;
        }
    }
    public static void gameResult(){
        /*
        5) Impossible when the grid has three X’s in a row as well as three O’s in a row, or there are
        a lot more X's than O's or vice versa (the difference should be 1 or 0;
        if the difference is 2 or more, then the game state is impossible).
        */

        if( xwins == false && owins == false && emty == true){
            System.out.println("Game not finished");
        }
        if( xwins == false && owins == true) {
            System.out.println("O wins");
        }
        if( xwins == true && owins == true){
            System.out.println("Draw");
        }
        if( xwins == true && owins == false) {
            System.out.println("X wins");
        }
    }

    public static void wins() {
        //check if all same on a row or below
        for (int a = 0; a < 3; a++){
            //->
            if(moves[a][0] == moves [a][1] && moves [a][1] == moves [a][2]){
                if(moves[a][0].contains("X")){
                    xwins = true;
                }
                if (moves[a][0].contains("O")){
                    owins = true;
                }
            }
            // down
            if(moves[0][a] == moves [1][a] && moves [1][a] == moves [2][a]) {
                if(moves[0][a].contains("X")){
                    xwins = true;
                }
                if (moves[0][a].contains("O")){
                    owins = true;
                }
            }
        }
        //diagonals
        if((moves[0][0] == moves [1][1] && moves [1][1] == moves [2][2])){
            if(moves[0][0].contains("X")){
                xwins = true;
            }
            if (moves[0][0].contains("O")){
                owins = true;
            }
        }
        if((moves[0][2] == moves [1][1] && moves [1][1] == moves [2][0])){
            if(moves[0][2].contains("X")){
                xwins = true;
            }
            if (moves[0][2].contains("O")){
                owins = true;
            }
        }
        System.out.println("I wnet in wins");
    }
    public static void printMoves () {
        for (int a = 0, b = 0, c = 0;; c++){
            if( a < 3 ) { //rows
                if( b < 3){ //number
                    System.out.print(moves[a][b]);
                    b++;
                } else if( b > 2){
                    b = 0;
                    a++;
                    System.out.println();
                }
            }
        }
    }
}
