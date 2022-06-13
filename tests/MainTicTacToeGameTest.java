import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MainTicTacToeGameTest {

    MainTicTacToeGame testGame = new MainTicTacToeGame();
    IndividualBox [][] testTicTacToeBoxes = MainTicTacToeGame.setUpTicTacToeBoxes(3);
    IndividualBox [][] testGameBoard;

    @BeforeEach
    void setUp() {
         testGameBoard = new IndividualBox[][]{{new IndividualBox("1"), new IndividualBox("2"),
                 new IndividualBox("3")}, {new IndividualBox("4"),
                 new IndividualBox("5"), new IndividualBox("6")},
                 {new IndividualBox("7"), new IndividualBox("8"), new IndividualBox("9")}};

    }



    @Test
    void testToSeeIfTicTacToeValuesWereSetUpCorrectly() {
        int sizeOfBoard = testGameBoard.length;

        String boxLabelDerivedFromTestFile = "";
        String boxLabelDerivedFromCallingFunction = "";
        for(int i = 0; i < sizeOfBoard; i++) {
            for (int j = 0; j < sizeOfBoard; j++) {
                boxLabelDerivedFromTestFile += testGameBoard[i][j].getBoxLabel();
                boxLabelDerivedFromCallingFunction += testTicTacToeBoxes[i][j].getBoxLabel();
            }
        }

        assertEquals(boxLabelDerivedFromTestFile, boxLabelDerivedFromCallingFunction);
    }
}
