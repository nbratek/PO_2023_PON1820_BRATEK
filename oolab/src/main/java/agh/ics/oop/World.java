package agh.ics.oop;

public class World {

    public static final String START = "system wystartował";
    public static final String STOP = "system zakończył działanie";

    public static void main(String[] args) {
        System.out.println(START);
        run(args);
        System.out.println(STOP);
    }

    public static void run(String[] args) {
        System.out.println("zwierzak idzie do przodu");
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i]);
            if (i < args.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}

