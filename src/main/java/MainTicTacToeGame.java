import java.util.InputMismatchException;
import java.util.Scanner;

public class MainTicTacToeGame {

    public static void main(String[] args){
        int playerNumber = 1;
        boolean validBoxSelection, validNumberOfPlayers = false;
        int userInput = -1;
        int amountOfPlayers = 2;
        int sizeOfBoard = 150;
        int lowerLimitOfPlayers = 2, upperLimitOfPlayers = 10;
        boolean someoneWon = false;
        boolean draw = false;
        IndividualBox[][] ticTacToeBoxes = setUpTicTacToeBoxes(sizeOfBoard);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac Toe!\n\n How many players will be playing? " +
                "(Enter an integer between " + lowerLimitOfPlayers + " and " + upperLimitOfPlayers + " : ");

        while(!validNumberOfPlayers) {
            try {
                userInput = scanner.nextInt();
                if (userInput >= lowerLimitOfPlayers && userInput <= upperLimitOfPlayers) {
                    validNumberOfPlayers = true;
                    amountOfPlayers = userInput;
                } else {
                    System.out.println("Please chose a integer between " + lowerLimitOfPlayers +
                            " and " + upperLimitOfPlayers + " : ");
                }
            }
            catch(InputMismatchException ime) {
                System.out.println("You did not enter an integer. Please chose an integer between "
                        + lowerLimitOfPlayers + " and " + upperLimitOfPlayers + " : ");
                String trash = scanner.next();
            }
        }


        GameBoardPrinter gameBoardPrinter = new GameBoardPrinter(sizeOfBoard);

        while(!someoneWon && !draw) {
            validBoxSelection = false;
            gameBoardPrinter.printTheGameBoard(ticTacToeBoxes);
            System.out.print("Player " + playerNumber + " it is your turn.\n" +
                    "Choose a box that has not previously been chosen by entering in that integer: ");

            while(!validBoxSelection){

                try{
                    userInput = scanner.nextInt();
                    BoxSelectionChecker boxSelectionChecker = new BoxSelectionChecker(ticTacToeBoxes, userInput);
                    if(boxSelectionChecker.isAValidSelection())
                    {
                        validBoxSelection = true;
                    }
                    else{
                        System.out.println("Choose an existing box that has not been chosen by entering in that integer: ");
                    }
                }
                catch(InputMismatchException ime) {
                    System.out.println("You did not enter an integer. Please enter your integer choice of an available box");
                    String trash = scanner.next();
                }
            }

            BoxSelector boxSelector = new BoxSelector(ticTacToeBoxes, playerNumber);
            boxSelector.makeBoxSelection(userInput);
            ticTacToeBoxes = boxSelector.getUpdatedGameBoard();

            EndOfGameChecker endOfGameChecker = new EndOfGameChecker(ticTacToeBoxes, playerNumber);
            someoneWon = endOfGameChecker.isThereAWinner();
            draw = endOfGameChecker.isThereADraw();

            System.out.println(); // for aesthetic appearance

            if(someoneWon) {
                gameBoardPrinter.printTheGameBoard(ticTacToeBoxes);
                System.out.println("Congratulations, player " + playerNumber + " you won!!!");
            }

            if(draw){
                gameBoardPrinter.printTheGameBoard(ticTacToeBoxes);
                System.out.println("Looks like it was a draw! Your skills are evenly matched. Thanks for playing!");
            }

            playerNumber++;
            if(playerNumber == (amountOfPlayers + 1)){
                playerNumber = 1;
            }
        }
    }

    public static IndividualBox [][] setUpTicTacToeBoxes(int gameBoardSize) {
        int labelNumberAssignedToBox = 1;
        IndividualBox [][] tempGameBoard = new IndividualBox[gameBoardSize][gameBoardSize];
        for(int i = 0; i < gameBoardSize; i++) {
            for(int j = 0; j < gameBoardSize; j++) {
                IndividualBox boxBeingAdded = new IndividualBox(String.valueOf((labelNumberAssignedToBox)));
                tempGameBoard[i][j] = boxBeingAdded;
                labelNumberAssignedToBox++;
            }
        }
        return tempGameBoard;
    }

}
