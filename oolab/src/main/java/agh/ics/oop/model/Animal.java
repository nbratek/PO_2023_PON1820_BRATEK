package agh.ics.oop.model;

public class Animal {
    MapDirection orientation;
    Vector2d position;

    public Animal() {
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }


    public Animal(Vector2d vector2d) {
        this.orientation = MapDirection.NORTH;
        this.position = vector2d;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return orientation.toString();
    }


    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move(MoveDirection direction, MoveValidator moveValidator) {
        Vector2d newPosition;
        switch (direction) {
            case FORWARD:
                newPosition = this.position.add(orientation.toUnitVector());
                break;
            case BACKWARD:
                newPosition = this.position.subtract(orientation.toUnitVector());
                break;
            case RIGHT:
                orientation = orientation.next();
                return;
            case LEFT:
                orientation = orientation.previous();
                return;
            default:
                return;
        }
        if (moveValidator.canMoveTo(newPosition)) {
            position = newPosition;
        }
    }
}
