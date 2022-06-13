import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BoxSelectorTest {

    IndividualBox[][] testGameBoard;

    IndividualBox [][] testReturnGameBoard = new IndividualBox[][]{{new IndividualBox("1"), new IndividualBox("*1*"),
            new IndividualBox("3")}, {new IndividualBox("4"),
            new IndividualBox("5"), new IndividualBox("6")},
        {new IndividualBox("7"), new IndividualBox("8"), new IndividualBox("9")}};


    @BeforeEach
    void setUp() {
         testGameBoard = new IndividualBox[][]{{new IndividualBox("1"), new IndividualBox("2"),
                 new IndividualBox("3")}, {new IndividualBox("4"),
                 new IndividualBox("5"), new IndividualBox("6")},
                 {new IndividualBox("7"), new IndividualBox("8"), new IndividualBox("9")}};
    }

    @Test
    void testBoxSelectorForPlayerOneSelection() {
        BoxSelector testBoxSelector = new BoxSelector(testGameBoard, 1);
        testBoxSelector.makeBoxSelection(2);
        assertEquals("*1*", testGameBoard[0][1].getBoxLabel());
    }

    @Test
    void testBoxSelectorForPlayerTwoSelection() {
        BoxSelector testBoxSelector = new BoxSelector(testGameBoard, 2);
        testBoxSelector.makeBoxSelection(2);
        assertEquals("*2*", testGameBoard[0][1].getBoxLabel());
    }

    @Test
    void testBoxSelectorToEnsureNewMapIsReturnedCorrectly() {
        BoxSelector testBoxSelector = new BoxSelector(testGameBoard, 1);
        testBoxSelector.makeBoxSelection(2);

        int sizeOfBoard = testGameBoard.length;

        testGameBoard = testBoxSelector.getUpdatedGameBoard();

        String boxLabelsOfTestGameBoard = "";
        String comparisonboxLabelsOfTestGameBoard = "";
        for(int i = 0; i < sizeOfBoard; i++) {
            for (int j = 0; j < sizeOfBoard; j++) {
                boxLabelsOfTestGameBoard += testGameBoard[i][j].getBoxLabel();
                comparisonboxLabelsOfTestGameBoard += testReturnGameBoard[i][j].getBoxLabel();
            }
        }

        assertEquals(boxLabelsOfTestGameBoard, comparisonboxLabelsOfTestGameBoard);
    }
}