import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Vector2dTest {
    @Test
    public void Vector2d_Add_ReturnsVector2d(){
        Vector2d vector2d = new Vector2d(1, 2);
        Vector2d other = new Vector2d(1, 3);

        Vector2d result = vector2d.add(other);

        assertEquals(result, new Vector2d(2, 5));
    }
    @Test
    public void Vector2d_Subtract_ReturnsVector2d(){
        Vector2d vector2d = new Vector2d(4, 9);
        Vector2d other = new Vector2d(2, 3);

        Vector2d result = vector2d.subtract(other);

        assertEquals(result, new Vector2d(2, 6));
    }

    @Test
    public void Vector2d_Opposite_ReturnsVector2d(){
        Vector2d vector2d = new Vector2d(-4, 5);

        Vector2d result = vector2d.opposite();

        assertEquals(result, new Vector2d(4, -5));
    }

    @Test
    public void Vector2d_Equals_ReturnsBoolean(){
        Vector2d vector2d_1 = new Vector2d(1, 2);
        Vector2d vector2d_2 = new Vector2d(1, 2);

        assertEquals(vector2d_1, vector2d_2);
    }

    @Test
    public void Vector2d_toString_ReturnsString(){
        Vector2d vector2d = new Vector2d(1, 2);

        assertEquals(vector2d.toString(), "(1,2)");
    }

    @Test
    public void Vector2d_Precedes_ReturnsBoolean(){
        Vector2d vector2d_1 = new Vector2d(1, 2);
        Vector2d vector2d_2 = new Vector2d(2, 3);

        assertTrue(vector2d_1.precedes(vector2d_2));
    }

    @Test
    public void Vector2d_Follows_ReturnsVector2d(){
        Vector2d vector2d_1 = new Vector2d(5, 4);
        Vector2d vector2d_2 = new Vector2d(1, 3);

        assertTrue(vector2d_1.follows(vector2d_2));
    }

    @Test
    public void Vector2d_UpperRight_ReturnsVector2d(){
        Vector2d vector2d = new Vector2d(1, 2);
        Vector2d other = new Vector2d(4, 6);

        Vector2d result = vector2d.upperRight(other);

        assertEquals(result, new Vector2d(4, 6));
    }

    @Test
    public void Vector2d_UpperLeft_ReturnsVector2d(){
        Vector2d vector2d = new Vector2d(1, 2);
        Vector2d other = new Vector2d(4, 6);

        Vector2d result = vector2d.upperLeft(other);

        assertEquals(result, new Vector2d(1, 2));
    }
}
