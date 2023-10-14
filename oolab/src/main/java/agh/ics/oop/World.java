package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {

    public static final String START = "system wystartował";
    public static final String STOP = "system zakończył działanie";

    public static void main(String[] args) {
        System.out.println(START);
        run(OptionsParser.parse(args));
        System.out.println(STOP);
    }

    public static void run(MoveDirection[] moveDirections) {
        for (int i = 0; i < moveDirections.length; i++) {
            switch (moveDirections[i]) {
                case FORWARD -> System.out.print("zwierzak idzie do przodu");
                case BACKWARD -> System.out.print("zwierzak idzie do tyłu");
                case RIGHT -> System.out.print("zwierzak idzie w prawo");
                case LEFT -> System.out.print("zwierzak idzie w lewo");
                default -> {
                }
            }
            if (i < moveDirections.length - 1) {
                System.out.print(", ");
            }
            System.out.println();
        }
    }
}

