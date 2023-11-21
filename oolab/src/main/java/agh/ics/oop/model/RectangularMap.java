package agh.ics.oop.model;

import java.util.UUID;

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
    public Boundary getCurrentBounds() {
        return new Boundary(new Vector2d(0,0), new Vector2d(4,4));
    }
}
