import agh.ics.oop.Simulation;
import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationTest {

    @Test
    public void Simulation_Run_ReturnsNothing_Case1(){
        //Given
        List<MoveDirection> moveDirectionList = List.of(MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.BACKWARD);
        List<Vector2d> positionList = List.of(new Vector2d(2, 2), new Vector2d(1, 2));
        RectangularMap rectangularMap = new RectangularMap(4,4);
        Simulation simulation = new Simulation(rectangularMap, positionList, moveDirectionList);
        //When
        simulation.run();
        //Then
        List<Animal> animals = simulation.getAnimalList();
        assertEquals(new Vector2d(2,3), animals.get(0).getPosition());
        assertEquals(new Vector2d(2, 2), animals.get(1).getPosition());
    }
    @Test
    public void Simulation_Run_ReturnsNothing_Case2(){
        //Given
        List<MoveDirection> moveDirectionList = List.of(MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.BACKWARD);
        List<Vector2d> positionList = List.of(new Vector2d(2, 2), new Vector2d(1, 2), new Vector2d(2, 1));
        RectangularMap rectangularMap = new RectangularMap(4,4);
        Simulation simulation = new Simulation(rectangularMap, positionList, moveDirectionList);
        //When
        simulation.run();
        //Then
        List<Animal> animals = simulation.getAnimalList();
        assertEquals(new Vector2d(2,2), animals.get(0).getPosition());
        assertEquals(new Vector2d(1, 2), animals.get(1).getPosition());
    }

    @Test
    public void Simulation_Run_ReturnsNothing_Case3(){
        //Given
        List<MoveDirection> moveDirectionList = List.of(MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.BACKWARD);
        List<Vector2d> positionList = List.of(new Vector2d(2, 2), new Vector2d(1, 2), new Vector2d(2, 1));
        GrassField grassField = new GrassField(3);
        Simulation simulation = new Simulation(grassField, positionList, moveDirectionList);
        //When
        simulation.run();
        //Then
        List<Animal> animals = simulation.getAnimalList();
        assertEquals(new Vector2d(2,2), animals.get(0).getPosition());
        assertEquals(new Vector2d(1, 2), animals.get(1).getPosition());
    }
}
