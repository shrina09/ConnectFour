package connectfour;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
* This class creates the board, sets the board, has a method to find winner, and has a method to write to a file
* @author Shrina
*/
public class Board {
    private ArrayList<ArrayList<String>> board = new ArrayList<>();
    private ArrayList<String> row1;
    private ArrayList<String> row2;
    private ArrayList<String> row3;
    private ArrayList<String> row4;
    private ArrayList<String> row5;
    private ArrayList<String> row6;
    private ArrayList<String> row7;
    private ArrayList<String> row8;
    private ArrayList<String> row9;
    private ArrayList<String> row10;
    private ArrayList<String> row11; 
   
    public Board() {
        row1 = new ArrayList<String>(Arrays.asList("0", "|", "0", "|", "0","|", "0", "|", "0", "|", "0","|", "0"));
        row2 = new ArrayList<String>(Arrays.asList("-", "+", "-", "+", "-","+", "-", "+", "-", "+", "-","+", "-"));
        row3 = new ArrayList<String>(Arrays.asList("0", "|", "0", "|", "0","|", "0", "|", "0", "|", "0","|", "0"));
        row4 = new ArrayList<String>(Arrays.asList("-", "+", "-", "+", "-","+", "-", "+", "-", "+", "-","+", "-"));
        row5 = new ArrayList<String>(Arrays.asList("0", "|", "0", "|", "0","|", "0", "|", "0", "|", "0","|", "0"));
        row6 = new ArrayList<String>(Arrays.asList("-", "+", "-", "+", "-","+", "-", "+", "-", "+", "-","+", "-"));
        row7 = new ArrayList<String>(Arrays.asList("0", "|", "0", "|", "0","|", "0", "|", "0", "|", "0","|", "0"));
        row8 = new ArrayList<String>(Arrays.asList("-", "+", "-", "+", "-","+", "-", "+", "-", "+", "-","+", "-"));
        row9 = new ArrayList<String>(Arrays.asList("0", "|", "0", "|", "0","|", "0", "|", "0", "|", "0","|", "0"));
        row10 = new ArrayList<String>(Arrays.asList("-", "+", "-", "+", "-","+", "-", "+", "-", "+", "-","+", "-"));
        row11 = new ArrayList<String>(Arrays.asList("0", "|", "0", "|", "0","|", "0", "|", "0", "|", "0","|", "0"));
        

        board.add(row1);
        board.add(row2);
        board.add(row3);
        board.add(row4);
        board.add(row5);
        board.add(row6);
        board.add(row7);
        board.add(row8);
        board.add(row9);
        board.add(row10);
        board.add(row11);
    }
    
   /**
   * Sets the position of the board and calls the printBoard After method from TextUI class
   * to print the board after its set
   * @param inputString 
   * @param player
   */
    public void setBoardPos(String inputString, String player){
        try{
            TextUI textObj = new TextUI();

            //Converts the input to the positions on the board
            int[] row = {0, 2, 4, 6, 8, 10};
            int[] column = {0, 2, 4, 6, 8, 10, 12};

            String[] tempString = inputString.split(",");

            int position1 = Integer.parseInt(tempString[0]);
            int position2 = Integer.parseInt(tempString[1]);

            //Setting the board
            board.get(row[position1]).set(column[position2], player);
            
            //For printing the board
            textObj.printBoardAfter(board); 
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Value entered is too large/small to be a position or input is not done as instructed");
        }  
    }
    
   /**
   * getter for the board 
   * @return board
   */
    public ArrayList<ArrayList<String>> getBoard() {
        return board;
    } 

    /**
   * For finding the winner
   * @param testCase
   * @return true if winner is found false otherwise
   */
    public boolean winner(int testCase) {
        boolean checkWin = false;
        
        //horizontal
        for (int i = 0; i < 11; i = i + 2) {
            for (int j = 0; j < 7; j = j+ 2) {
                if (board.get(i).get(j) != "0" &&board.get(i).get(j) == board.get(i).get(j+2) 
                    &&board.get(i).get(j) == board.get(i).get(j+4) &&board.get(i).get(j) == board.get(i).get(j+6)) {
                    testCase = 1;
                    checkWin = true;
                }
            }         
        }

        //vertical
        for (int i = 0; i < 13; i = i + 2) {
            for (int j = 0; j < 5; j = j + 2) {
               if (board.get(j).get(i) != "0" && board.get(j).get(i) == board.get(j+2).get(i) 
                    &&board.get(j).get(i) == board.get(j+4).get(i) &&board.get(j).get(i) == board.get(j+6).get(i)) {   
                    testCase = 2;    
                    checkWin = true;
                }
            }
        }

        //Diagonal upward
        for (int i = 0; i > 7; i = i + 2){
            for (int j = 10; j > 5; j = j - 2) {
                if(board.get(i).get(j) != "0" && board.get(i).get(j) == board.get(i+2).get(j-2) 
                   && board.get(i).get(j) == board.get(i+4).get(j-4) && board.get(i).get(j) == board.get(i+6).get(j-6)){
                    testCase = 3;
                    checkWin = true;
                }
            }
        }
        
        //Diagonal downwards
        for(int i = 0; i < 5; i = i + 2) {
            for(int j = 0; j < 7; j += 2) {
                if (board.get(i).get(j) != "0" && board.get(i).get(j) == board.get(i+2).get(j+2) 
                    && board.get(i).get(j) == board.get(i+4).get(j+4) && board.get(i).get(j)==board.get(i+6).get(j+6)){
                    testCase = 4;
                    checkWin = true;
                }
            }
        }

        return checkWin;
    }  
    
   /**
   * For writing the board's content in a file
   * @param filePath
   */
    public void writeFile(String filePath){
      
        try{
            File csvWriter = new File(filePath);
            FileWriter write = new FileWriter(csvWriter);
            for (int i = 0; i < 11; i = i+2) {
                for (int j = 0; j < 13; j += 2) {
                    write.write(board.get(i).get(j));
                    if (j < 11) {
                        write.write(",");
                    }
                }
                write.write("\n");
            }

            write.close();
        }catch(IOException exe){
            System.out.println("Cannot create file");
        }
    }

   /**
   * toString function for this class
   */
    public String toString() {
        return "Contains the board";
    }
}  
