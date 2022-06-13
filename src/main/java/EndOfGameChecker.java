public class EndOfGameChecker {

    IndividualBox[][] ticTacToeBoxes;
    int gameBoardSize;
    int playerNumber;
    int totalNumberOfBoxes;

    public EndOfGameChecker(IndividualBox[][] ticTacToeBoxesIn, int playerNum) {
        ticTacToeBoxes = ticTacToeBoxesIn;
        gameBoardSize = ticTacToeBoxes.length;
        playerNumber = playerNum;
        totalNumberOfBoxes = gameBoardSize * gameBoardSize;
    }

    public boolean isThereADraw(){
        GameboardToStringConverter gameboardConverter = new GameboardToStringConverter(ticTacToeBoxes);
        String allGameBoardLabels = gameboardConverter.getAllLabelsAsOneString();
        String nonMarkedBoxes = allGameBoardLabels.replaceAll("\\*\\d+\\*", "X");

        String drawMatch = "";
        for(int i = 0; i < totalNumberOfBoxes; i++)
        {
            drawMatch += " X ";
        }


        if(nonMarkedBoxes.matches(drawMatch))
        {
            return true;
        }
        return false;
    }

    public boolean isThereAWinner()
    {
        boolean horizontalWin = checkHorizontals();
        boolean verticalWin = checkVerticals();
        boolean diagonalWin = checkDiagonals();
        return (horizontalWin || verticalWin || diagonalWin);
    }

    private boolean checkHorizontals() {
        for(int row = 0; row < gameBoardSize; row++)
        {
            StringBuilder necessaryWinningLabel = new StringBuilder();
            StringBuilder horizontalLabels = new StringBuilder();
            for(int column = 0; column < gameBoardSize; column++) {
                horizontalLabels.append(ticTacToeBoxes[row][column].getBoxLabel());
                necessaryWinningLabel.append("*").append(playerNumber).append("*");
            }
            if(horizontalLabels.toString().equals(necessaryWinningLabel.toString())){
                return true;
            }
        }
        return false;
    }

    private boolean checkVerticals() {

        for (int column = 0; column < gameBoardSize; column++) {
            StringBuilder verticalLabels = new StringBuilder();
            StringBuilder necessaryWinningLabel = new StringBuilder();


            for (int row = 0; row < gameBoardSize; row++) {
                verticalLabels.append(ticTacToeBoxes[row][column].getBoxLabel());
                necessaryWinningLabel.append("*").append(playerNumber).append("*");
            }

            if (verticalLabels.toString().equals(necessaryWinningLabel.toString())) {
                return true;
            }

        }


        return false;
    }

    private boolean checkDiagonals() {
        boolean leftToRight = isDiagonalLeftToRightAWinner();
        boolean rightToLeft = isDiagonalRightToLeftAWinner();

        if(leftToRight || rightToLeft){
            return true;
        }
        return false;
    }

    private boolean isDiagonalLeftToRightAWinner() {
        StringBuilder leftToRightDiagonalLabels = new StringBuilder();
        StringBuilder necessaryWinningLabel = new StringBuilder();

        for(int row = 0; row < gameBoardSize; row++) {
            for(int column = 0; column < gameBoardSize; column++) {
                if(row == column)
                {
                    leftToRightDiagonalLabels.append(ticTacToeBoxes[row][column].getBoxLabel());
                    necessaryWinningLabel.append("*").append(playerNumber).append("*");
                }
            }
        }

        if (leftToRightDiagonalLabels.toString().equals(necessaryWinningLabel.toString())) {
            return true;
        }
        return false;
    }

    private boolean isDiagonalRightToLeftAWinner() {
        StringBuilder rightToLeftDiagonalLabels = new StringBuilder();
        StringBuilder necessaryWinningLabel = new StringBuilder();

        int columnToCheck = gameBoardSize -1;

        for(int row = 0; row < gameBoardSize; row++) {
            for(int column = 0; column < gameBoardSize; column++) {
                if(column == columnToCheck)
                {
                    rightToLeftDiagonalLabels.append(ticTacToeBoxes[row][column].getBoxLabel());
                }
            }
            necessaryWinningLabel.append("*").append(playerNumber).append("*");
            columnToCheck--;
        }

        if (rightToLeftDiagonalLabels.toString().equals(necessaryWinningLabel.toString())) {
            return true;
        }
        return false;
    }
}
