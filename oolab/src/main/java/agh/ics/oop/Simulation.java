package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    List<Animal> animalList;
    List<MoveDirection> moveDirectionsList;

    public Simulation(List<Vector2d> vector2dList, List<MoveDirection> moveDirectionsList) {
        this.animalList = initAnimalList(vector2dList);
        this.moveDirectionsList = moveDirectionsList;
    }

    public void run() {
        for (int i = 0; i < moveDirectionsList.size(); i++) {
            int animalIdx = i % animalList.size();
            Animal animal = animalList.get(animalIdx);
            MoveDirection moveDirection = moveDirectionsList.get(i);
            animal.move(moveDirection);
            System.out.println("Zwierzę " + animalIdx + ": " + animal);
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
