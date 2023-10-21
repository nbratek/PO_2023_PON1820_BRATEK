import agh.ics.oop.model.MapDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {
    @Test
    public void MapDirection_Next_ReturnsMapDirection_Case1(){
        // Given
        MapDirection mapDirection = MapDirection.NORTH;

        // When
        MapDirection result = mapDirection.next();

        // Then
        assertEquals(result, MapDirection.EAST);

    }
    @Test
    public void MapDirection_Next_ReturnsMapDirection_Case2(){
        // Given
        MapDirection mapDirection = MapDirection.EAST;

        // When
        MapDirection result = mapDirection.next();

        // Then
        assertEquals(result, MapDirection.SOUTH);

    }

    @Test
    public void MapDirection_Next_ReturnsMapDirection_Case3(){
        // Given
        MapDirection mapDirection = MapDirection.SOUTH;

        // When
        MapDirection result = mapDirection.next();

        // Then
        assertEquals(result, MapDirection.WEST);

    }
    @Test
    public void MapDirection_Next_ReturnsMapDirection_Case4(){
        // Given
        MapDirection mapDirection = MapDirection.WEST;

        // When
        MapDirection result = mapDirection.next();

        // Then
        assertEquals(result, MapDirection.NORTH);

    }

    @Test
    public void MapDirection_Previous_ReturnsMapDirection_Case1() {
        // Given
        MapDirection mapDirection = MapDirection.NORTH;

        // When
        MapDirection result = mapDirection.previous();

        // Then
        assertEquals(result, MapDirection.WEST);
    }

    @Test
    public void MapDirection_Previous_ReturnsMapDirection_Case2() {
        // Given
        MapDirection mapDirection = MapDirection.WEST;

        // When
        MapDirection result = mapDirection.previous();

        // Then
        assertEquals(result, MapDirection.SOUTH);
    }

    @Test
    public void MapDirection_Previous_ReturnsMapDirection_Case3() {
        // Given
        MapDirection mapDirection = MapDirection.SOUTH;

        // When
        MapDirection result = mapDirection.previous();

        // Then
        assertEquals(result, MapDirection.EAST);
    }

    @Test
    public void MapDirection_Previous_ReturnsMapDirection_Case4() {
        // Given
        MapDirection mapDirection = MapDirection.EAST;

        // When
        MapDirection result = mapDirection.previous();

        // Then
        assertEquals(result, MapDirection.NORTH);
    }
}
