import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EndOfGameCheckerTest {

    @Test
    void testIfWillReturnTrueWhenThereIsADraw() {
        System.out.println("testIfWillReturnTrueWhenThereIsADraw");
        IndividualBox[][] horizontalVictoryBoard = new IndividualBox[][]{{new IndividualBox("*3*"), new IndividualBox("*1*"),
                new IndividualBox("*2*")}, {new IndividualBox("*7*"),
                new IndividualBox("*6*"), new IndividualBox("*10*")},
                {new IndividualBox("*5*"), new IndividualBox("*2*"), new IndividualBox("*2*")}};
        EndOfGameChecker testEndOfGameChecker = new EndOfGameChecker(horizontalVictoryBoard, 1);
        assertTrue(testEndOfGameChecker.isThereADraw());
    }

    @Test
    void testIfWillReturnTrueWhenThereIsAPlayerOneHorizontalVictory() {
        IndividualBox [][] horizontalVictoryBoard = new IndividualBox[][]{{new IndividualBox("1"), new IndividualBox("2"),
                new IndividualBox("3")}, {new IndividualBox("*1*"),
                new IndividualBox("*1*"), new IndividualBox("*1*")},
                {new IndividualBox("7"), new IndividualBox("8"), new IndividualBox("9")}};
        EndOfGameChecker testEndOfGameChecker = new EndOfGameChecker(horizontalVictoryBoard, 1);
        assertTrue(testEndOfGameChecker.isThereAWinner());
    }

    @Test
    void testIfWillReturnTrueWhenThereIsAPlayerTenHorizontalVictoryOnLargerBoard() {
        IndividualBox[][] horizontalLargeVictoryBoard= {{new IndividualBox("1"), new IndividualBox("2"),
                new IndividualBox("3"),new IndividualBox("4"), new IndividualBox("5"),
                new IndividualBox("6")}, {new IndividualBox("7"), new IndividualBox("8"),
                new IndividualBox("9"),new IndividualBox("10"), new IndividualBox("11"),
                new IndividualBox("12")}, {new IndividualBox("*10*"), new IndividualBox("*10*"),
                new IndividualBox("*10*"),new IndividualBox("*10*"), new IndividualBox("*10*"),
                new IndividualBox("*10*")}, {new IndividualBox("19"), new IndividualBox("20"),
                new IndividualBox("21"),new IndividualBox("22"), new IndividualBox("23"),
                new IndividualBox("24")}, {new IndividualBox("25"), new IndividualBox("26"),
                new IndividualBox("27"),new IndividualBox("28"), new IndividualBox("29"),
                new IndividualBox("30")}, {new IndividualBox("31"), new IndividualBox("32"),
                new IndividualBox("33"),new IndividualBox("34"), new IndividualBox("35"),
                new IndividualBox("36")}};
        EndOfGameChecker testEndOfGameChecker = new EndOfGameChecker(horizontalLargeVictoryBoard, 10);
        assertTrue(testEndOfGameChecker.isThereAWinner());
    }

    @Test
    void testIfWillReturnTrueWhenThereIsAPlayerTwoHorizontalVictory() {
        IndividualBox [][] horizontalVictoryBoard = new IndividualBox[][]{{new IndividualBox("1"), new IndividualBox("2"),
                new IndividualBox("3")}, {new IndividualBox("*2*"),
                new IndividualBox("*2*"), new IndividualBox("*2*")},
                {new IndividualBox("7"), new IndividualBox("8"), new IndividualBox("9")}};
        EndOfGameChecker testEndOfGameChecker = new EndOfGameChecker(horizontalVictoryBoard, 2);
        assertTrue(testEndOfGameChecker.isThereAWinner());
    }

    @Test
    void testIfWillReturnTrueWhenThereIsAPlayerOneVerticalVictory() {
        IndividualBox [][] verticalVictoryBoard = new IndividualBox[][]{{new IndividualBox("1"), new IndividualBox("*1*"),
                new IndividualBox("3")}, {new IndividualBox("4"),
                new IndividualBox("*1*"), new IndividualBox("6")},
                {new IndividualBox("7"), new IndividualBox("*1*"), new IndividualBox("9")}};
        EndOfGameChecker testEndOfGameChecker = new EndOfGameChecker(verticalVictoryBoard, 1);
        assertTrue(testEndOfGameChecker.isThereAWinner());
    }

    @Test
    void testIfWillReturnTrueWhenThereIsAPlayerTwoVerticalVictory() {
        System.out.println("Verticals Two");
        IndividualBox [][] verticalVictoryBoard = new IndividualBox[][]{{new IndividualBox("1"), new IndividualBox("*2*"),
                new IndividualBox("3")}, {new IndividualBox("4"),
                new IndividualBox("*2*"), new IndividualBox("6")},
                {new IndividualBox("7"), new IndividualBox("*2*"), new IndividualBox("9")}};
        EndOfGameChecker testEndOfGameChecker = new EndOfGameChecker(verticalVictoryBoard, 2);
        assertTrue(testEndOfGameChecker.isThereAWinner());
    }

    @Test
    void testIfWillReturnTrueWhenThereIsADiagonalLeftToRightVictory() {
        IndividualBox [][] leftToRightDiagonalVictoryBoard = new IndividualBox[][]{{new IndividualBox("*1*"), new IndividualBox("2"),
                new IndividualBox("3")}, {new IndividualBox("4"),
                new IndividualBox("*1*"), new IndividualBox("6")},
                {new IndividualBox("7"), new IndividualBox("8"), new IndividualBox("*1*")}};
        EndOfGameChecker testEndOfGameChecker = new EndOfGameChecker(leftToRightDiagonalVictoryBoard, 1);
        assertTrue(testEndOfGameChecker.isThereAWinner());
    }

    @Test
    void testIfWillReturnTrueWhenThereIsADiagonalRightToLeftVictory() {
        System.out.println("testIfWillReturnTrueWhenThereIsADiagonalRightToLeftVictory");
        IndividualBox [][] rightToLeftDiagonalVictoryBoard = new IndividualBox[][]{{new IndividualBox("1"), new IndividualBox("2"),
                new IndividualBox("*1*")}, {new IndividualBox("4"),
                new IndividualBox("*1*"), new IndividualBox("6")},
                {new IndividualBox("*1*"), new IndividualBox("8"), new IndividualBox("9")}};
        EndOfGameChecker testEndOfGameChecker = new EndOfGameChecker(rightToLeftDiagonalVictoryBoard, 1);
        assertTrue(testEndOfGameChecker.isThereAWinner());
    }

    @Test
    void testIfWillReturnFalseWhenNoOneWinsButThereAreStillThreeOsOnTheBoard() {
        IndividualBox [][] randomOsOnBoard = new IndividualBox[][]{{new IndividualBox("1"), new IndividualBox("*2*"),
                new IndividualBox("*2*")}, {new IndividualBox("*2*"),
                new IndividualBox("5"), new IndividualBox("6")},
                {new IndividualBox("7"), new IndividualBox("8"), new IndividualBox("9")}};
        EndOfGameChecker testEndOfGameChecker = new EndOfGameChecker(randomOsOnBoard, 2);
        assertFalse(testEndOfGameChecker.isThereAWinner());
    }

    @Test
    void testIfWillReturnFalseWhenNothingHasBeenPlacedOnTheBoardYet() {
        IndividualBox [][] nothingOnBoard = new IndividualBox[][]{{new IndividualBox("1"), new IndividualBox("2"),
                new IndividualBox("3")}, {new IndividualBox("4"),
                new IndividualBox("5"), new IndividualBox("6")},
                {new IndividualBox("7"), new IndividualBox("8"), new IndividualBox("9")}};
        EndOfGameChecker testEndOfGameChecker = new EndOfGameChecker(nothingOnBoard, 1);
        assertFalse(testEndOfGameChecker.isThereAWinner());
    }

    @Test
    void testIfWillReturnFalseWhenThereAreStillBoxesAvailibleToSelect() {
        IndividualBox[][] stillAvailableBoxesBoard = new IndividualBox[][]{{new IndividualBox("*1*"), new IndividualBox("*1*"),
                new IndividualBox("*2*")}, {new IndividualBox("4"),
                new IndividualBox("*1*"), new IndividualBox("*1*")},
                {new IndividualBox("7"), new IndividualBox("*2*"), new IndividualBox("*2*")}};
        EndOfGameChecker testEndOfGameChecker = new EndOfGameChecker(stillAvailableBoxesBoard, 2);
        assertFalse(testEndOfGameChecker.isThereADraw());
    }

    @Test
    void testIfWillReturnFalseWhenThereIsStillOneBoxAvailibleToSelect() {
        IndividualBox[][] oneBoxLeftBoard = new IndividualBox[][]{{new IndividualBox("*1*"), new IndividualBox("*1*"),
                new IndividualBox("*2*")}, {new IndividualBox("4"),
                new IndividualBox("*1*"), new IndividualBox("*1*")},
                {new IndividualBox("*1*"), new IndividualBox("*2*"), new IndividualBox("*2*")}};
        EndOfGameChecker testEndOfGameChecker = new EndOfGameChecker(oneBoxLeftBoard, 2);
        assertFalse(testEndOfGameChecker.isThereADraw());
    }
}