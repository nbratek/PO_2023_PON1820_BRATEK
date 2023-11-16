import agh.ics.oop.exception.PositionAlreadyOccupiedException;
import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    @Test
    public void GrassField_ObjectAt_ReturnsWorldElement_Case1() throws PositionAlreadyOccupiedException {
        Animal animal = new Animal();
        GrassField grassField = new GrassField(3);
        grassField.place(animal);
        Vector2d vector2d = new Vector2d(2, 2);

        WorldElement result = grassField.objectAt(vector2d);

        assertNotNull(result);
        assertEquals(result, animal);


    }

    @Test
    public void GrassField_ObjectAt_ReturnsWorldElement_Case2() throws PositionAlreadyOccupiedException {
        Animal animal = new Animal();
        GrassField grassField = new GrassField(3);
        grassField.place(animal);
        Vector2d vector2d = new Vector2d(2, 3);

        WorldElement result = grassField.objectAt(vector2d);

        assertNotEquals(result, animal);

    }

    @Test
    public void GrassField_Place_ReturnsBoolean() throws PositionAlreadyOccupiedException {
        //given
        Animal animal = new Animal();
        GrassField grassField = new GrassField(3);
        grassField.place(animal);
    }

    @Test
    public void GrassField_IsOccupied_ReturnsBoolean() throws PositionAlreadyOccupiedException {
        //given
        Animal animal = new Animal();
        GrassField grassField = new GrassField(3);
        grassField.place(animal);
        Vector2d vector2d = new Vector2d(2,2);
        //when
        boolean result = grassField.isOccupied(vector2d);
        //then
        assertTrue(result);
    }
    @Test
    public void GrassField_CanMoveTo_ReturnsBoolean() throws PositionAlreadyOccupiedException {
        //given
        Animal animal = new Animal();
        GrassField grassField = new GrassField(3);
        grassField.place(animal);
        Vector2d vector2d = new Vector2d(2,3);
        //when
        boolean result = grassField.canMoveTo(vector2d);
        //then
        assertTrue(result);
    }

    @Test
    public void GrassField_Move_ReturnsNothing() throws PositionAlreadyOccupiedException {
        //given
        Animal animal = new Animal();
        GrassField grassField = new GrassField(3);
        grassField.place(animal);
        //when
        grassField.move(animal, MoveDirection.BACKWARD);
        //then
        assertEquals(animal.getPosition(), new Vector2d(2,1));
        assertEquals(animal.getOrientation(), MapDirection.NORTH);
    }


    @Test
    public void GrassField_GetElements_ReturnsWorldElementList() throws PositionAlreadyOccupiedException {
        GrassField grassField = new GrassField(3);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(2,3));
        Animal animal3 = new Animal(new Vector2d(3, 2));
        grassField.place(animal1);
        grassField.place(animal2);
        grassField.place(animal3);

        List<WorldElement> result = grassField.getElements();

        assertNotNull(result);
        assertEquals(result.size(), 6);
    }


}
