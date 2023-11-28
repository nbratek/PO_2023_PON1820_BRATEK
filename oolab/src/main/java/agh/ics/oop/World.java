package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class World {

    public static final String START = "system wystartował";
    public static final String STOP = "system zakończył działanie";

    public static void main(String[] args) {

        //lab1

        System.out.println(START);
        run(OptionsParser.parse(args));
        System.out.println(STOP);

        // lab2

        Vector2d position1 = new Vector2d(1, 2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2, 1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        //lab3, lab4

        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));



        //lab7
        List<Simulation> simulationList = new ArrayList<>();
        for(int i = 0;i < 100; i++){
             RectangularMap rectangularMap = new RectangularMap(4,4);
             ConsoleMapDisplay consoleMapDisplay = new ConsoleMapDisplay();
             rectangularMap.addObserver(consoleMapDisplay);
             simulationList.add(new Simulation(rectangularMap, positions, directions));

        }
        SimulationEngine simulationEngine = new SimulationEngine(simulationList);
        simulationEngine.runAsyncInThreadPool();

    }

    public static void run(List<MoveDirection> moveDirections) {
        for (int i = 0; i < moveDirections.size(); i++) {
            switch (moveDirections.get(i)) {
                case FORWARD -> System.out.print("zwierzak idzie do przodu");
                case BACKWARD -> System.out.print("zwierzak idzie do tyłu");
                case RIGHT -> System.out.print("zwierzak idzie w prawo");
                case LEFT -> System.out.print("zwierzak idzie w lewo");
                default -> {
                }
            }
            if (i < moveDirections.size() - 1) {
                System.out.print(", ");
            }
            System.out.println();
        }
    }
}

