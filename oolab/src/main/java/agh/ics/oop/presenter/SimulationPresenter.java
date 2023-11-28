package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
        drawMap(message);
    }

    @FXML
    public void onSimulationStartClicked() {
        String[] moveArray = movesTextField.getText().split(",");
        List<MoveDirection> directions = OptionsParser.parse(moveArray);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
        Simulation simulation = new Simulation(worldMap, positions, directions);
        simulation.run();
    }
}
