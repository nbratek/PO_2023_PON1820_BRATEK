package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap {

    private final int width;
    private final int height;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (position == null){
            return false;
        }
        return position.precedes(new Vector2d(4, 4)) && position.follows(new Vector2d(0, 0)) && !isOccupied(position);
    }

    @Override
    public Vector2d getLowerLeft() {
        return new Vector2d(0,0);
    }

    @Override
    public Vector2d getUpperRight() {
        return new Vector2d(4,4);
    }
}
