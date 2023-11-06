import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    @Test
    public void Animal_ToString_ReturnsString_Case1(){
        //given
        Animal animal = new Animal();
        //when
        String result = animal.toString();
        //then
        assertEquals(result, "N");
    }
    @Test
    public void Animal_ToString_ReturnsString_Case2(){
        //given
        Vector2d vector2d = new Vector2d(3, 4);
        Animal animal = new Animal(vector2d);
        //when
        String result = animal.toString();
        //then
        assertEquals(result, "N");
    }
    @Test
    public void Animal_IsAT_ReturnsBoolean_Case1(){
        //given
        Vector2d vector2d = new Vector2d(3, 4);
        Animal animal = new Animal(vector2d);
        //when
        boolean result = animal.isAt(vector2d);
        //then
        assertTrue(result);
    }
    @Test
    public void Animal_IsAT_ReturnsBoolean_Case2(){
        //given
        Vector2d vector2d = new Vector2d(3, 4);
        Animal animal = new Animal(vector2d);
        //when
        boolean result = animal.isAt(new Vector2d(5, 6));
        //then
        assertFalse(result);
    }

    @Test
    public void Animal_Move_ReturnsNothing_Case1(){
        Animal animal = new Animal();
        RectangularMap rectangularMap = new RectangularMap(3,3);
        animal.move(MoveDirection.BACKWARD, rectangularMap);
        assertEquals(animal.getPosition(), new Vector2d(2, 1));

    }

    @Test
    public void Animal_Move_ReturnsNothing_Case3(){
        Animal animal = new Animal();
        RectangularMap rectangularMap = new RectangularMap(3,3);
        animal.move(MoveDirection.FORWARD, rectangularMap);
        assertEquals(animal.getPosition(), new Vector2d(2, 3));

    }

    @Test
    public void Animal_Move_ReturnsNothing_Case2(){
        Animal animal = new Animal();
        RectangularMap rectangularMap = new RectangularMap(3,3);
        animal.move(MoveDirection.LEFT, rectangularMap);
        assertEquals(animal.getOrientation(), MapDirection.WEST);

    }
    @Test
    public void Animal_Move_ReturnsNothing_Case4(){
        Animal animal = new Animal();
        RectangularMap rectangularMap = new RectangularMap(3,3);
        animal.move(MoveDirection.RIGHT, rectangularMap);
        assertEquals(animal.getOrientation(), MapDirection.EAST);

    }
}
