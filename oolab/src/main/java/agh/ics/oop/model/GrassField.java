package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap {

    private final int grassCount;

    private final List<Grass> grassList;

    public GrassField(int grassCount) {
        this.grassCount = grassCount;
        this.grassList = new ArrayList<>();
        init();
    }


    private void init() {
        Random random = new Random();
        int placedGrassCount = 0;
        while (placedGrassCount < grassCount) {
            int x = random.nextInt((int) Math.sqrt(grassCount * 10));
            int y = random.nextInt((int) Math.sqrt(grassCount * 10));
            Vector2d vector2d = new Vector2d(x, y);
            if (canMoveTo(vector2d)) {
                Grass grass = new Grass(vector2d);
                grassList.add(grass);
                placedGrassCount++;
            }
        }
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        WorldElement animal = super.objectAt(position);
        if (animal != null) {
            return animal;
        }
        for (Grass grass : grassList) {
            if (grass.getPosition().equals(position)) {
                return grass;
            }
        }
        return null;
    }

    @Override
    public Vector2d getLowerLeft() {
        return new Vector2d(0, 0);
    }

    @Override
    public Vector2d getUpperRight() {
        return new Vector2d((int) Math.sqrt(grassCount * 10), (int) Math.sqrt(grassCount * 10));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (position == null) {
            return false;
        }
        return position.precedes(new Vector2d((int) Math.sqrt(grassCount * 10), (int) Math.sqrt(grassCount * 10))) && position.follows(new Vector2d(0, 0)) && !isOccupied(position);
    }
}
