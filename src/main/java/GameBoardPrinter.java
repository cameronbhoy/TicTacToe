public class GameBoardPrinter {
    int totalNumberOfRowsInGameBoard, totalNumberOfBoxesOnBoard, amountOfNecessaryCharacters;

    public GameBoardPrinter(int totalNumberOfRowsInGameBoard_in) {
        totalNumberOfRowsInGameBoard = totalNumberOfRowsInGameBoard_in;
        totalNumberOfBoxesOnBoard = totalNumberOfRowsInGameBoard * totalNumberOfRowsInGameBoard;
        amountOfNecessaryCharacters = getNecessaryCharactersPerBox();

        if(amountOfNecessaryCharacters < 4)
        {
            amountOfNecessaryCharacters = 4;
        }
    }

    public void printTheGameBoard(IndividualBox[][] gameBoardValues)
    {
        System.out.println(getUnlabeledLine(totalNumberOfRowsInGameBoard));
        for(int rowOfGameBoard = 0; rowOfGameBoard < totalNumberOfRowsInGameBoard; rowOfGameBoard++)
        {
            System.out.println(getLabeledLine(gameBoardValues, rowOfGameBoard));
            System.out.println(getUnlabeledLine(totalNumberOfRowsInGameBoard));
        }
    }

    private String getUnlabeledLine(int totalNumberOfRowsInGameBoard) {
        String lineToBeReturned = "|";
        for(int rowOfGameBoard = 0; rowOfGameBoard < totalNumberOfRowsInGameBoard; rowOfGameBoard++) {
            for(int charOfBox = 0; charOfBox < amountOfNecessaryCharacters; charOfBox++) {
                lineToBeReturned += "-";
            }
            lineToBeReturned += "|";
        }
        return lineToBeReturned;
    }

    private String getLabeledLine(IndividualBox[][] testGameBoard, int rowOfGameBoard) {
        String lineToBeReturned = "|";
        for(int row = 0; row < totalNumberOfRowsInGameBoard; row++) {
            lineToBeReturned += getBlankSpacesAndLabel(testGameBoard[rowOfGameBoard][row]) + "|";
        }
        return lineToBeReturned;
    }

    private int getNecessaryCharactersPerBox(){
        String biggestNumberCharsTogether = String.valueOf(totalNumberOfBoxesOnBoard);
        int numberOfCharsToHoldBiggestNumber = biggestNumberCharsTogether.length();
        return numberOfCharsToHoldBiggestNumber;
    }

    private String getBlankSpacesAndLabel(IndividualBox box){
        String currentLabel = box.getBoxLabel();
        int boxLabelLength = currentLabel.length();
        int blankSpaces = amountOfNecessaryCharacters - boxLabelLength;
        StringBuilder labelAndSpaces = new StringBuilder();

        labelAndSpaces.append(getBlankSpaces((blankSpaces / 2)));
        labelAndSpaces.append(currentLabel);
        labelAndSpaces.append(getBlankSpaces((blankSpaces / 2)));

        //ensure that all boxes will be of uniform length
        while(labelAndSpaces.length() < amountOfNecessaryCharacters){
            labelAndSpaces.append(" ");
        }

        return labelAndSpaces.toString();
    }

    private String getBlankSpaces(int blankSpaces) {
        StringBuilder spaces = new StringBuilder();
        for(int i = 0; i < blankSpaces; i++){
            spaces.append(" ");
        }
        return spaces.toString();
    }
}
