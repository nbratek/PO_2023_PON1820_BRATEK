package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine {

    private List<Simulation> simulationList;

    public SimulationEngine(List<Simulation> simulationList) {
        this.simulationList = simulationList;
    }

    public void runSync(){
        for (Simulation simulation: simulationList){
            simulation.run();
        }
    }

    public void runAsync(){
        List<Thread> threads = new ArrayList<>();
        for (Simulation simulation: simulationList){
            Thread thread = new Thread(simulation::run);
            threads.add(thread);
            thread.start();
        }
   //     awaitSimulationsEnd(threads);
    }

    public void awaitSimulationsEnd(List<Thread> threads){
        for (Thread thread: threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void runAsyncInThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (Simulation simulation : simulationList) {
            executorService.submit(simulation::run);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
