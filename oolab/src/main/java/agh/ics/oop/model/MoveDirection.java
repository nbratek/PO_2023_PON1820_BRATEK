package agh.ics.oop.model;

public enum MoveDirection {
    FORWARD("Zwierzak idzie do przodu"),
    BACKWARD("Zwierzak idzie do tyłu"),
    RIGHT("Zwierzak skręca w prawo"),
    LEFT("Zwierzak skręca w lewo");

    private final String description;

    MoveDirection(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
