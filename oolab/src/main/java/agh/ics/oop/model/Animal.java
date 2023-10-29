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
        return "Zwierzę na pozycji " + position + " skierowane na " + orientation;
    }


    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move(MoveDirection direction) {
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
        if (newPosition.precedes(new Vector2d(4, 4)) && newPosition.follows(new Vector2d(0, 0))) {
            position = newPosition;
        }
    }
}
