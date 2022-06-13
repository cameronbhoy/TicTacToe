import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndividualBoxTest {
    IndividualBox testBox = new IndividualBox("1");
    @Test
    void shouldReturnCorrectLabel() {
        assertEquals("1", testBox.getBoxLabel());
    }

}