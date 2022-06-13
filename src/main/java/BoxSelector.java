public class BoxSelector {
    IndividualBox [][] ticTacToeBoxes;
    int playerNumber;

    public BoxSelector(IndividualBox [][] ticTacToeBoxesIn, int currentPlayer) {
        ticTacToeBoxes = ticTacToeBoxesIn;
        playerNumber = currentPlayer;
    }

    public void makeBoxSelection(int userBoxSelection)
    {
        int sizeOfBoard = ticTacToeBoxes.length;
        for(int i = 0; i < sizeOfBoard; i++) {
            for(int j = 0; j < sizeOfBoard; j++) {
                IndividualBox currentBox = ticTacToeBoxes[i][j];
                if(currentBox.getBoxLabel().equals(String.valueOf(userBoxSelection))) {
                    ticTacToeBoxes[i][j].selectThisBox(String.valueOf(playerNumber));
                }
            }
        }
    }

    public IndividualBox[][] getUpdatedGameBoard(){
        return ticTacToeBoxes;
    }

}
