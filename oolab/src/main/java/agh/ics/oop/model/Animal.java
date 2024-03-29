package agh.ics.oop.model;

public class Animal implements WorldElement {
    private MapDirection orientation;
    private Vector2d position;
    private final String symbol;

    public Animal() {
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
        this.symbol ="";
    }

    public Animal(Vector2d vector2d) {
        this.orientation = MapDirection.NORTH;
        this.position = vector2d;
        this.symbol = "";
    }

    public Animal(Vector2d vector2d, String symbol) {
        this.orientation = MapDirection.NORTH;
        this.position = vector2d;
        this.symbol = symbol;
    }


    @Override
    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return orientation.toString();
    }

    public MapDirection getOrientation() {
        return orientation;
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
