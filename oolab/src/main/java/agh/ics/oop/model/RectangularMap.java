package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap, MoveValidator {

    private final int width;
    private final int height;

    private final Map<Vector2d, Animal> animals;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.animals = new HashMap<>();
    }

    @Override
    public String toString() {
        Vector2d lowerLeft = new Vector2d(0,0);
        Vector2d upperRight = new Vector2d(width - 1, height - 1);
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(lowerLeft, upperRight);
    }

    @Override
    public boolean place(Animal animal) {
        if(animal != null && canMoveTo(animal.getPosition())){
            animals.put(animal.position, animal);
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        animal.move(direction, this);
        Vector2d newPosition = animal.getPosition();
        if(!oldPosition.equals(newPosition)){
            animals.remove(oldPosition);
            animals.put(newPosition, animal);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (position == null){
            return false;
        }
        return position.precedes(new Vector2d(4, 4)) && position.follows(new Vector2d(0, 0)) && !isOccupied(position);
    }
}
