public class GameboardToStringConverter {
    private IndividualBox[][] ticTacToeBoxes;
    private int gameBoardSize;

    public GameboardToStringConverter(IndividualBox[][] ticTacToeBoxesIn) {
        ticTacToeBoxes = ticTacToeBoxesIn;
        gameBoardSize = ticTacToeBoxes.length;
    }

    public String getAllLabelsAsOneString() {
        StringBuilder allLabels = new StringBuilder();
        for(int i = 0; i < gameBoardSize; i++) {
            for (int j = 0; j < gameBoardSize; j++) {
                allLabels.append(" " + ticTacToeBoxes[i][j].getBoxLabel() + " ");
            }
        }
        return allLabels.toString();
    }
}
