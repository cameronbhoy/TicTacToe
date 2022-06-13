import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.jupiter.api.Assertions.*;

class GameBoardPrinterTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @Test
    void testForCorrectPrintingOfSmallGameBoard() {
        IndividualBox[][] testGameBoard = {{new IndividualBox("1"), new IndividualBox("2"),
                new IndividualBox("3")}, {new IndividualBox("4"),
                new IndividualBox("5"), new IndividualBox("6")},
                {new IndividualBox("7"), new IndividualBox("8"), new IndividualBox("9")}};
        GameBoardPrinter testPrinter = new GameBoardPrinter(testGameBoard.length);

        System.setOut(new PrintStream(outputStreamCaptor));
        testPrinter.printTheGameBoard(testGameBoard);

        assertEquals("|----|----|----|\n" +
                "| 1  | 2  | 3  |\n" +
                "|----|----|----|\n" +
                "| 4  | 5  | 6  |\n" +
                "|----|----|----|\n" +
                "| 7  | 8  | 9  |\n" +
                "|----|----|----|", outputStreamCaptor.toString()
                .trim());
        System.setOut(standardOut);
    }

    @Test
    void testForCorrectPrintingOfLargeGameBoard() {
        IndividualBox[][] testGameBoard = {{new IndividualBox("1"), new IndividualBox("2"),
                new IndividualBox("3"),new IndividualBox("4"), new IndividualBox("5"),
                new IndividualBox("6")}, {new IndividualBox("7"), new IndividualBox("8"),
                new IndividualBox("9"),new IndividualBox("10"), new IndividualBox("11"),
                new IndividualBox("12")}, {new IndividualBox("13"), new IndividualBox("14"),
                new IndividualBox("15"),new IndividualBox("16"), new IndividualBox("17"),
                new IndividualBox("18")}, {new IndividualBox("19"), new IndividualBox("20"),
                new IndividualBox("21"),new IndividualBox("22"), new IndividualBox("23"),
                new IndividualBox("24")}, {new IndividualBox("25"), new IndividualBox("26"),
                new IndividualBox("27"),new IndividualBox("28"), new IndividualBox("29"),
                new IndividualBox("30")}, {new IndividualBox("31"), new IndividualBox("32"),
                new IndividualBox("33"),new IndividualBox("34"), new IndividualBox("35"),
                new IndividualBox("36")}};
        GameBoardPrinter testPrinter = new GameBoardPrinter(testGameBoard.length);

        System.setOut(new PrintStream(outputStreamCaptor));
        testPrinter.printTheGameBoard(testGameBoard);

        assertEquals("|----|----|----|----|----|----|\n" +
                "| 1  | 2  | 3  | 4  | 5  | 6  |\n" +
                "|----|----|----|----|----|----|\n" +
                "| 7  | 8  | 9  | 10 | 11 | 12 |\n" +
                "|----|----|----|----|----|----|\n" +
                "| 13 | 14 | 15 | 16 | 17 | 18 |\n" +
                "|----|----|----|----|----|----|\n" +
                "| 19 | 20 | 21 | 22 | 23 | 24 |\n" +
                "|----|----|----|----|----|----|\n" +
                "| 25 | 26 | 27 | 28 | 29 | 30 |\n" +
                "|----|----|----|----|----|----|\n" +
                "| 31 | 32 | 33 | 34 | 35 | 36 |\n" +
                "|----|----|----|----|----|----|", outputStreamCaptor.toString()
                .trim());
        System.setOut(standardOut);
    }

}