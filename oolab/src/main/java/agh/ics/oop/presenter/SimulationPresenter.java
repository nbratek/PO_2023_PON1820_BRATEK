package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class SimulationPresenter implements MapChangeListener {

    @FXML
    private TextField movesTextField;

    @FXML
    private Label infoLabel;

    private WorldMap worldMap;

    public void setWorldMap(WorldMap map){
        this.worldMap = map;
    }

    public void drawMap(String message){
        infoLabel.setText(message);

    }


    @Override
    public void mapChanged(WorldMap worldMap, String message) {

        Platform.runLater(() -> {
            drawMap(message);

        });

    }

    @FXML
    public void onSimulationStartClicked() {
        try{
            String[] moveArray = movesTextField.getText().split(",");
            List<MoveDirection> directions = OptionsParser.parse(moveArray);
            List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(0,0));
            Simulation simulation = new Simulation(worldMap, positions, directions);
            List<Simulation> simulationList = new ArrayList<>();
            simulationList.add(simulation);
            SimulationEngine simulationEngine = new SimulationEngine(simulationList);
            simulationEngine.runAsync();

        } catch (IllegalArgumentException error) {
            infoLabel.setText("Incorrect input. Please enter f, l, r or b without unnecessary space.");
        }
    }
}
