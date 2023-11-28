package agh.ics.oop.model;

import agh.ics.oop.exception.PositionAlreadyOccupiedException;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap, MoveValidator {

    protected final Map<Vector2d, Animal> animals;
    private final List<MapChangeListener> listeners;

    private final UUID id;

    protected AbstractWorldMap() {
        this.id = UUID.randomUUID();
        this.animals = new HashMap<>();
        this.listeners = new ArrayList<>();
    }

    @Override
    public UUID getId() {
        return id;
    }

    public void addObserver(MapChangeListener observer) {
        listeners.add(observer);
    }
    public void removeObserver(MapChangeListener observer) {
        listeners.remove(observer);
    }
    public void notifyObservers(String message) {
        for(MapChangeListener mapChangeListener: listeners){
            mapChangeListener.mapChanged(this, message);
        }
    }

    @Override
    public void place(Animal animal) throws PositionAlreadyOccupiedException {
        if (animal != null && canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            notifyObservers("animal placed on " + animal.getPosition());
            return;
        }
        throw new PositionAlreadyOccupiedException(animal.getPosition());
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        animal.move(direction, this);
        Vector2d newPosition = animal.getPosition();
        if (!oldPosition.equals(newPosition)) {
            animals.remove(oldPosition);
            animals.put(newPosition, animal);
            notifyObservers("animal moved to " + newPosition);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public String toString() {
        Boundary boundary = getCurrentBounds();
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(boundary.lowerLeft(), boundary.upperRight());
    }

    @Override
    public List<WorldElement> getElements() {
        return new ArrayList<>(animals.values());
    }


    public abstract Boundary getCurrentBounds();


}
