import agh.ics.oop.model.Grass;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrassTest {

    @Test
    public void Grass_GetPosition_ReturnsVector2d() {
        Grass grass = new Grass(new Vector2d(2,2));

        Vector2d result = grass.getPosition();

        assertEquals(result, new Vector2d(2,2));
    }
}
