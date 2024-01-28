package agh.ics.oop.model;

import java.util.UUID;

public class RectangularMap extends AbstractWorldMap {

    private final int maxX;
    private final int maxY;
    private final int minX;
    private final int minY;



    public RectangularMap(int width, int height) {
        this.maxX = width;
        this.maxY = height;
        this.minY = 0;
        this.minX = 0;
    }

    public RectangularMap(int maxWidth, int maxHeight, int minX, int minY){
        this.maxX = maxWidth;
        this.maxY = maxHeight;
        this.minX = minX;
        this.minY = minY;
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        if (position == null){
            return false;
        }
        return position.precedes(new Vector2d(maxX, maxY)) && position.follows(new Vector2d(minX, minY)) && !isOccupied(position);
    }

    @Override
    public Boundary getCurrentBounds() {
        return new Boundary(new Vector2d(minX,minY), new Vector2d(maxX,maxY));
    }
}
