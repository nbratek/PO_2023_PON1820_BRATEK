package agh.ics.oop;

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
        animalList.forEach(worldMap::place);
        System.out.println(worldMap);
        for (int i = 0; i < moveDirectionsList.size(); i++) {
            int animalIdx = i % animalList.size();
            Animal animal = animalList.get(animalIdx);
            MoveDirection moveDirection = moveDirectionsList.get(i);
            worldMap.move(animal, moveDirection);
            System.out.println(worldMap);
        }
    }

    private List<Animal> initAnimalList(List<Vector2d> positionList) {
        List<Animal> animals = new ArrayList<>();
        for (Vector2d vector2d : positionList) {
            animals.add(new Animal(vector2d));
        }
        return animals;
    }



}
