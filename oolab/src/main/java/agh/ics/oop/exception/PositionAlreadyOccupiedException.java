package agh.ics.oop.exception;

import agh.ics.oop.model.Vector2d;

public class PositionAlreadyOccupiedException extends Exception {
    public PositionAlreadyOccupiedException(Vector2d position) {
        super("Position " + position + " is already occupied");
    }
}
