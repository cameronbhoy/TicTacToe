public class BoxSelectionChecker {
    private IndividualBox[][] ticTacToeBoxes;
    private int userBoxSelection, sizeOfBoard, numberOfBoxesOnBoard;

    public BoxSelectionChecker(IndividualBox[][] ticTacToeBoxesIn, int userBoxSelectionIn) {
        ticTacToeBoxes = ticTacToeBoxesIn;
        userBoxSelection = userBoxSelectionIn;
        sizeOfBoard = ticTacToeBoxes.length;
        numberOfBoxesOnBoard = sizeOfBoard * sizeOfBoard;
    }

    public boolean isAValidSelection()
    {
        if(isUserInputIsAWithinRangeOfBoardSize() && isUserSelectionIsAvailable()) {
            return true;
        }
        return false;
    }

    private boolean isUserInputIsAWithinRangeOfBoardSize() {
        if(userBoxSelection >= 1 && userBoxSelection <= numberOfBoxesOnBoard){
            return true;
        }
        return false;
    }

    private boolean isUserSelectionIsAvailable() {
        GameboardToStringConverter gameBoardConverter = new GameboardToStringConverter(ticTacToeBoxes);
        String allBoxLabels = gameBoardConverter.getAllLabelsAsOneString();
        int locationOfBox = getLocationOfSelectedBox(allBoxLabels, userBoxSelection);
        if(locationOfBox != -1) {
            return true;
        }
        return false;
    }

    private int getLocationOfSelectedBox(String allLabels, int userInput) {
        String nonMarkedBoxes = allLabels.replaceAll("\\*\\d+\\*", "");
        String convertedUserInput = String.valueOf(userInput);
        int locationOfDesiredLabel = allLabels.indexOf(convertedUserInput);
        return locationOfDesiredLabel;
    }
}
