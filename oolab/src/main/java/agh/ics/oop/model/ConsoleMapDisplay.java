package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {

    private int counter = 0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        counter++;
        System.out.println("Id: " + worldMap.getId());
        System.out.println("Message: " + message);
        System.out.println("Current map state: " + worldMap.toString());
        System.out.println("Total update: " + counter);
    }
}
