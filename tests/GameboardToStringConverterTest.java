import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameboardToStringConverterTest {

    IndividualBox[][] testGameBoard = {{new IndividualBox("1"), new IndividualBox("2"),
            new IndividualBox("3")}, {new IndividualBox("4"),
            new IndividualBox("5"), new IndividualBox("6")},
            {new IndividualBox("7"), new IndividualBox("8"), new IndividualBox("9")}};

    @Test
    void testToEnsureThatGameBoardIsSuccessfullyConvertedToAString() {
        GameboardToStringConverter testGameboardConverter = new GameboardToStringConverter(testGameBoard);
        String testGameBoardAsString = testGameboardConverter.getAllLabelsAsOneString();
        String expected = " 1  2  3  4  5  6  7  8  9 ";
        assertEquals(expected, testGameBoardAsString);
    }
}