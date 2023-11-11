import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    @Test
    public void RectangularMap_IsOccupied_ReturnsBoolean_Case1() {
        //given
        Animal animal = new Animal();
        RectangularMap rectangularMap = new RectangularMap(4,4);
        rectangularMap.place(animal);
        Vector2d vector2d = new Vector2d(2,2);
        //when
        boolean result = rectangularMap.isOccupied(vector2d);
        //then
        assertTrue(result);
    }
    @Test
    public void RectangularMap_IsOccupied_ReturnsBoolean_Case2() {
        //given
        Animal animal = new Animal();
        RectangularMap rectangularMap = new RectangularMap(4,4);
        rectangularMap.place(animal);
        Vector2d vector2d = new Vector2d(3,2);
        //when
        boolean result = rectangularMap.isOccupied(vector2d);
        //then
        assertFalse(result);
    }

    @Test
    public void RectangularMap_IsOccupied_ReturnsBoolean_Case3() {
        //given
        Animal animal = new Animal();
        RectangularMap rectangularMap = new RectangularMap(4,4);
        rectangularMap.place(animal);
        Vector2d vector2d = null;
        //when
        boolean result = rectangularMap.isOccupied(vector2d);
        //then
        assertFalse(result);
    }

    @Test
    public void RectangularMap_ObjectAt_ReturnsAnimal_Case1(){
        //given
        Animal animal = new Animal();
        RectangularMap rectangularMap = new RectangularMap(4,4);
        rectangularMap.place(animal);
        Vector2d vector2d = new Vector2d(2,2);
        //when
        WorldElement result = rectangularMap.objectAt(vector2d);
        //then
        assertNotNull(result);
        assertEquals(result, animal);
    }


    @Test
    public void RectangularMap_ObjectAt_ReturnsAnimal_Case2(){
        //given
        Animal animal = new Animal();
        RectangularMap rectangularMap = new RectangularMap(4,4);
        rectangularMap.place(animal);
        Vector2d vector2d = new Vector2d(3,2);
        //when
        WorldElement result = rectangularMap.objectAt(vector2d);
        //then
        assertNull(result);
    }

    @Test
    public void RectangularMap_ObjectAt_ReturnsAnimal_Case3(){
        //given
        Animal animal = new Animal();
        RectangularMap rectangularMap = new RectangularMap(4,4);
        rectangularMap.place(animal);
        Vector2d vector2d = null;
        //when
        WorldElement result = rectangularMap.objectAt(vector2d);
        //then
        assertNull(result);
    }

    @Test
    public void RectangularMap_CanMoveTo_ReturnsBoolean_Case1(){
        //given
        Animal animal = new Animal();
        RectangularMap rectangularMap = new RectangularMap(4,4);
        rectangularMap.place(animal);
        Vector2d vector2d = new Vector2d(2,2);
        //when
        boolean result = rectangularMap.canMoveTo(vector2d);
        //then
        assertFalse(result);
    }

    @Test
    public void RectangularMap_CanMoveTo_ReturnsBoolean_Case2(){
        //given
        Animal animal = new Animal();
        RectangularMap rectangularMap = new RectangularMap(4,4);
        rectangularMap.place(animal);
        Vector2d vector2d = new Vector2d(1,2);
        //when
        boolean result = rectangularMap.canMoveTo(vector2d);
        //then
        assertTrue(result);
    }
    @Test
    public void RectangularMap_CanMoveTo_ReturnsBoolean_Case3(){
        //given
        Animal animal = new Animal();
        RectangularMap rectangularMap = new RectangularMap(4,4);
        rectangularMap.place(animal);
        Vector2d vector2d = null;
        //when
        boolean result = rectangularMap.canMoveTo(vector2d);
        //then
        assertFalse(result);
    }

    @Test
    public void RectangularMap_Place_ReturnsBoolean_Case1() {
        //given
        Animal animal = new Animal();
        RectangularMap rectangularMap = new RectangularMap(4, 4);
        rectangularMap.place(animal);
        Animal animal1 = new Animal(new Vector2d(3,1));
        //when
        boolean result = rectangularMap.place(animal1);
        //then
        assertTrue(result);
    }

    @Test
    public void RectangularMap_Place_ReturnsBoolean_Case2() {
        //given
        Animal animal = new Animal();
        RectangularMap rectangularMap = new RectangularMap(4, 4);
        rectangularMap.place(animal);
        Animal animal1 = new Animal(new Vector2d(2,2));
        //when
        boolean result = rectangularMap.place(animal1);
        //then
        assertFalse(result);
    }

    @Test
    public void RectangularMap_Place_ReturnsBoolean_Case3() {
        //given
        Animal animal = new Animal();
        RectangularMap rectangularMap = new RectangularMap(4, 4);
        rectangularMap.place(animal);
        Animal animal1 = null;
        //when
        boolean result = rectangularMap.place(animal1);
        //then
        assertFalse(result);
    }

    @Test
    public void RectangularMap_Move_ReturnsNothing_Case1() {
        //given
        Animal animal = new Animal();
        RectangularMap rectangularMap = new RectangularMap(4, 4);
        rectangularMap.place(animal);
        //when
        rectangularMap.move(animal, MoveDirection.BACKWARD);
        //then
        assertEquals(animal.getPosition(), new Vector2d(2,1));
        assertEquals(animal.getOrientation(), MapDirection.NORTH);
    }

    @Test
    public void RectangularMap_Move_ReturnsNothing_Case2() {
        //given
        Animal animal = new Animal();
        RectangularMap rectangularMap = new RectangularMap(4, 4);
        rectangularMap.place(animal);
        //when
        rectangularMap.move(animal, MoveDirection.FORWARD);
        //then
        assertEquals(animal.getPosition(), new Vector2d(2,3));
        assertEquals(animal.getOrientation(), MapDirection.NORTH);
    }

    @Test
    public void RectangularMap_Move_ReturnsNothing_Case3() {
        //given
        Animal animal = new Animal();
        RectangularMap rectangularMap = new RectangularMap(4, 4);
        rectangularMap.place(animal);
        //when
        rectangularMap.move(animal, MoveDirection.LEFT);
        //then
        assertEquals(animal.getPosition(), new Vector2d(2,2));
        assertEquals(animal.getOrientation(), MapDirection.WEST);
    }

    @Test
    public void RectangularMap_Move_ReturnsNothing_Case4() {
        //given
        Animal animal = new Animal();
        RectangularMap rectangularMap = new RectangularMap(4, 4);
        rectangularMap.place(animal);
        //when
        rectangularMap.move(animal, MoveDirection.RIGHT);
        //then
        assertEquals(animal.getPosition(), new Vector2d(2,2));
        assertEquals(animal.getOrientation(), MapDirection.EAST);
    }

    @Test
    public void RectangularMap_GetLowerLeft_ReturnsVector2d(){
        RectangularMap rectangularMap = new RectangularMap(4,4);
        Vector2d result = rectangularMap.getLowerLeft();
        assertEquals(result, new Vector2d(0,0));
    }
    @Test
    public void RectangularMap_GetUpperRight_ReturnsVector2d(){
        RectangularMap rectangularMap = new RectangularMap(4,4);
        Vector2d result = rectangularMap.getUpperRight();
        assertEquals(result, new Vector2d(4,4));
    }

    @Test
    public void RectangularMap_GetElements_ReturnsWorldElementList() {
        RectangularMap rectangularMap = new RectangularMap(4,4);
        Animal animal1 = new Animal();
        Animal animal2 = new Animal(new Vector2d(2,3));
        Animal animal3 = new Animal(new Vector2d(3, 2));
        rectangularMap.place(animal1);
        rectangularMap.place(animal2);
        rectangularMap.place(animal3);

        List<WorldElement> result = rectangularMap.getElements();

        assertNotNull(result);
        assertEquals(result.size(), 3);
    }
}


