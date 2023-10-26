package agh.ics.oop.model;

public enum MapDirection {
    NORTH, EAST, SOUTH, WEST;

    @Override
    public String toString() {
        return switch (this) {
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case EAST -> "Wschód";
            case WEST -> "Zachód";
        };
    }

    public MapDirection next() {
        MapDirection[] mapDirections = values();
        int idx = ordinal();
        int nextIdx = idx + 1;
        if (nextIdx >= mapDirections.length) {
            nextIdx = 0;
        }
        return mapDirections[nextIdx];
    }

    public MapDirection previous() {
        MapDirection[] mapDirections = values();
        int idx = ordinal();
        int nextIdx = idx - 1;
        if (nextIdx < 0) {
            nextIdx = mapDirections.length - 1;
        }
        return mapDirections[nextIdx];
    }

    public Vector2d toUnitVector() {
        return switch (this) {
            case NORTH -> new Vector2d(0, 1);
            case SOUTH -> new Vector2d(0, -1);
            case WEST -> new Vector2d(-1, 0);
            case EAST -> new Vector2d(1, 0);
        };
    }

}
