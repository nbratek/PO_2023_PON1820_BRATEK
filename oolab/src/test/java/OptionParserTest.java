import agh.ics.oop.OptionsParser;
import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class OptionParserTest {
    @Test
    public void OptionsParserTest_Parse_ReturnsMoveDirectionList() {
        String[] args = {"f", "r", "l"};

        List<MoveDirection> moveDirections = OptionsParser.parse(args);

        assertEquals(3, moveDirections.size());
        assertSame(moveDirections.get(0), MoveDirection.FORWARD);
        assertSame(moveDirections.get(1), MoveDirection.RIGHT);
        assertSame(moveDirections.get(2), MoveDirection.LEFT);
    }

}
