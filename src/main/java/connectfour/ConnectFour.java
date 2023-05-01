package connectfour;

/**
* This class has the main method that runs the game, a setTurn method to set the next player,
* a isTie method to check if its a tie and a toString method. The overall purpose of this class
* is to run the game
* @author Shrina
*/
public class ConnectFour {

    public static void main(String[] args){
        int depthGame = 0;
        int caseTest = 0;
        Board boardObj = new Board();
        TextUI objText = new TextUI();
        ConnectFour connectObj = new ConnectFour();
        String userPrompt; 
        String  userFile;
        String player = "1";
        boolean won;
        boolean tie; 
        
        objText.printBoardInitial();
        userPrompt = objText.promptUser();

        if (userPrompt.equals("F")) {
            userFile = objText.fileName();
            boardObj.writeFile(userFile);
        }else {
            boardObj.setBoardPos(userPrompt, player);

            player = connectObj.setTurn(player);
            tie = connectObj.isTie(depthGame);

            while (!tie) {
                depthGame++;
                userPrompt = objText.promptUser();
                
                if (userPrompt.equals("F")) {
                    userFile = objText.fileName();
                    boardObj.writeFile(userFile);
                }else {
                    boardObj.setBoardPos(userPrompt, player);
                    won = boardObj.winner(caseTest);
                    tie = connectObj.isTie(depthGame);

                    if (won) {
                        objText.printWinner(player);
                        break;
                    } else if (tie) {
                        objText.printTie();
                        break;
                    }

                    player = connectObj.setTurn(player);
                }
            }
        }    
    }


    public String setTurn(String playerSet) {
        
        String returnString = "0";

        if(playerSet == "1") {
            returnString = "2";

        }else if(playerSet == "2"){
            returnString = "1";
        }

        return returnString;
    }

    public boolean isTie(int depthGame){
        if (depthGame == 42) {
            return true;
        }
        return false; 
    }

    public String toString(){
        return "ConnectFour Class";
    }
}