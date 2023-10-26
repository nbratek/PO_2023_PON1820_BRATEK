package agh.ics.oop.model;

import java.util.Objects;

public class Vector2d {

    private final int x;

    private final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x +
                "," + y +
                ')';
    }

    public boolean precedes(Vector2d other) {
        return (this.x <= other.getX() && this.y <= other.getY());
    }

    public boolean follows(Vector2d other) {
        return (this.x >= other.getX() && this.y >= other.getY());
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(this.x + other.getX(), this.y + other.getY());
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x - other.getX(), this.y - other.getY());
    }

    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(this.x, other.getX()), Math.max(this.y, other.getY()));
    }

    public Vector2d upperLeft(Vector2d other) {
        return new Vector2d(Math.min(this.x, other.getX()), Math.min(this.y, other.getY()));
    }

    public Vector2d opposite() {
        return new Vector2d(-this.x, -this.y);
    }

    @Override
    public int hashCode() {
         return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Vector2d vector2d)) {
            return false;
        }

        return hashCode() == vector2d.hashCode();
    }
}
