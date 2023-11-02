import agh.ics.oop.Simulation;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationTest {

    @Test
    public void Simulation_Run_ReturnsNothing(){
        //Given
        List<MoveDirection> moveDirectionList = List.of(MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.BACKWARD);
        List<Vector2d> positionList = List.of(new Vector2d(2, 2), new Vector2d(1, 2));
        Simulation simulation = new Simulation(positionList, moveDirectionList);
        //When
        simulation.run();
        //Then
        List<Animal> animals = simulation.getAnimalList();
        assertEquals(new Vector2d(2,3), animals.get(0).getPosition());
        assertEquals(new Vector2d(2, 2), animals.get(1).getPosition());
    }
}
