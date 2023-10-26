package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.List;

import static agh.ics.oop.model.MoveDirection.*;

public class World {

    public static final String START = "system wystartował";
    public static final String STOP = "system zakończył działanie";

    public static void main(String[] args) {

        //lab1

        System.out.println(START);
        run(OptionsParser.parse(args));
        System.out.println(STOP);

        // lab2

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
    }

    public static void run(List<MoveDirection> moveDirections) {
        for (int i = 0; i < moveDirections.size(); i++) {
            switch (moveDirections.get(i)) {
                case FORWARD -> System.out.print("zwierzak idzie do przodu");
                case BACKWARD -> System.out.print("zwierzak idzie do tyłu");
                case RIGHT -> System.out.print("zwierzak idzie w prawo");
                case LEFT -> System.out.print("zwierzak idzie w lewo");
                default -> {
                }
            }
            if (i < moveDirections.size() - 1) {
                System.out.print(", ");
            }
            System.out.println();
        }
    }
}

