package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) {
        MoveDirection[] moveDirections = new MoveDirection[args.length];
        int i = 0;
        for (String arg : args) {
            switch (arg) {
                case "f" -> moveDirections[i] = MoveDirection.FORWARD;
                case "b" -> moveDirections[i] = MoveDirection.BACKWARD;
                case "r" -> moveDirections[i] = MoveDirection.RIGHT;
                case "l" -> moveDirections[i] = MoveDirection.LEFT;
                default -> moveDirections[i] = null;
            }
            if (moveDirections[i] != null) {
                i += 1;
            }
        }
        return java.util.Arrays.copyOf(moveDirections, i);
    }
}