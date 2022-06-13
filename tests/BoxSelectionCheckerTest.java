import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoxSelectionCheckerTest {
    IndividualBox[][] testGameBoard = {{new IndividualBox("1"), new IndividualBox("2"),
            new IndividualBox("3")}, {new IndividualBox("*1*"),
            new IndividualBox("*2*"), new IndividualBox("6")},
            {new IndividualBox("7"), new IndividualBox("8"), new IndividualBox("9")}};



    @Test
    void testInputValidityCheckerByTryingToSelectAMarkedBox() {
        BoxSelectionChecker testBoxSelector = new BoxSelectionChecker(testGameBoard, 5);
        assertFalse(testBoxSelector.isAValidSelection());
    }

    @Test
    void testInputValidityCheckerByTryingToSelectABoxAboveRange() {
        BoxSelectionChecker testBoxSelector = new BoxSelectionChecker(testGameBoard, 12);
        assertFalse(testBoxSelector.isAValidSelection());
    }

    @Test
    void testInputValidityCheckerByTryingToSelectABoxBelowRange() {
        BoxSelectionChecker testBoxSelector = new BoxSelectionChecker(testGameBoard, 0);
        assertFalse(testBoxSelector.isAValidSelection());
    }

    @Test
    void testInputValidityCheckerBySelectingAValidInput() {
        BoxSelectionChecker testBoxSelector = new BoxSelectionChecker(testGameBoard, 3);
        assertTrue(testBoxSelector.isAValidSelection());
    }
}