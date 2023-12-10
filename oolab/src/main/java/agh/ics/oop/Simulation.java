package agh.ics.oop;

import agh.ics.oop.exception.PositionAlreadyOccupiedException;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final WorldMap worldMap;
    private final List<Animal> animalList;
    private final List<MoveDirection> moveDirectionsList;

    public Simulation(WorldMap worldMap, List<Vector2d> vector2dList, List<MoveDirection> moveDirectionsList) {
        this.worldMap = worldMap;
        this.animalList = initAnimalList(vector2dList);
        this.moveDirectionsList = moveDirectionsList;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void run() {
        try {
            for(Animal animal : animalList) {
                try {
                    worldMap.place(animal);
                    Thread.sleep(400);
                } catch (PositionAlreadyOccupiedException e) {
                    System.out.println(e.getMessage());
                }
            }

            for (MoveDirection direction : moveDirectionsList){
                for (Animal animal: animalList) {
                    worldMap.move(animal, direction);
                    Thread.sleep(400);

                }

            }
        } catch (InterruptedException ignored) {}

    }

    private List<Animal> initAnimalList(List<Vector2d> positionList) {
        String[] symbols = {"x", "?", "!", "o", ">", "<"};
        List<Animal> animals = new ArrayList<>();
        int i = 0;
        for (Vector2d vector2d : positionList) {
            animals.add(new Animal(vector2d, symbols[i% symbols.length]));
            i++;
        }
        return animals;
    }



}
