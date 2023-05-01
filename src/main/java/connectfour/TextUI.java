package connectfour;
import java.util.Scanner; 
import java.util.ArrayList;
/**
* This class has the scanner object and a promptUser method to take the user Input,
* fileName method to take the name of the file to write to, printBoardInitial to print
* the initial board (default board), printBoardAfter function to print the board after 
* it has been set, printWinner method to print the winner, printTie method to print
* its a tie, and a toString method. The point of this class is to take user input 
* and do any kind of printing
* @author Shrina
*/
public class TextUI{
    private Scanner uInput;

    public TextUI(){
        uInput = new Scanner(System.in);
    }

    public String promptUser() {
        System.out.print("Enter a value between 0-5 for rows & 0-6 for column to play (Ex: 0,0) ");
        System.out.println("enter F to load the board on a file: ");

        String userInput = uInput.next();

        return userInput;
    }

    public String fileName() {
        System.out.println("Enter the name of the file(if out of this directory enter the path with it): ");
        String filename = uInput.next();
        return filename;
    }



    public void printBoardInitial() {
        Board boardText = new Board();

        for (int i = 0; i < boardText.getBoard().size(); i++) {

            for (int j = 0; j < boardText.getBoard().get(0).size(); j++) {
                System.out.print(boardText.getBoard().get(i).get(j));
            }
            System.out.print("\n");    
        }

       
        System.out.println("\n");
    }
    public void printBoardAfter(ArrayList<ArrayList<String>> board1) {
        for (int i = 0; i < board1.size(); i++) {

            for (int j = 0; j < board1.get(0).size(); j++) {
                System.out.print(board1.get(i).get(j));
            }
            System.out.print("\n");    
        }

    }

    public void printWinner(String aPlayer) {

        System.out.println("Winner is " + aPlayer);
    }

    public void printTie() {
        System.out.println("It's a tie");
    }

   

   
    public String toString() {
        return "Contains a scanner object";
    }

}
