import agh.ics.oop.OptionsParser;
import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class OptionParserTest {
    @Test
    public void OptionsParserTest_Parse_ReturnsMoveDirectionList() {
        String[] args = {"f", "dsfsdf", "r", "l"};

        MoveDirection[] moveDirections = OptionsParser.parse(args);

        assertEquals(3, moveDirections.length);
        assertSame(moveDirections[0], MoveDirection.FORWARD);
        assertSame(moveDirections[1], MoveDirection.RIGHT);
        assertSame(moveDirections[2], MoveDirection.LEFT);
    }

}
