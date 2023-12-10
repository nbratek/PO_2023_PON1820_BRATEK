package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;
import java.util.List;

public class SimulationPresenter implements MapChangeListener {

    private static final int MAP_SIZE = 10;
    private static final int CELL_SIZE = 40;

    @FXML
    private TextField movesTextField;

    @FXML
    private Label infoLabel;

    @FXML
    private GridPane mapGrid;

    private WorldMap worldMap;

    public void initialize(){
        Platform.runLater(this::prepareGrid);
    }

    public void setWorldMap(WorldMap map){
        this.worldMap = map;
    }

    public void drawMap(String message){
        Platform.runLater(() -> {
            infoLabel.setText(message);
        });
        worldMap.getElements()
                .forEach(worldElement -> {
                    int x = worldElement.getPosition().getX();
                    int y = worldElement.getPosition().getY();
                    Platform.runLater(() -> drawAnimalPosition(worldElement.getSymbol(), x, y));
                });
    }


    @Override
    public void mapChanged(WorldMap worldMap, String message) {
            drawMap(message);

    }

    @FXML
    public void onSimulationStartClicked() {
        Platform.runLater(() -> {
            cleanGrid();
            prepareGrid();
        });
        try{
            String[] moveArray = movesTextField.getText().split(",");
            List<MoveDirection> directions = OptionsParser.parse(moveArray);
            List<Vector2d> positions = List.of(new Vector2d(-3, -2), new Vector2d(1,1));
            Simulation simulation = new Simulation(worldMap, positions, directions);
            List<Simulation> simulationList = new ArrayList<>();
            simulationList.add(simulation);
            SimulationEngine simulationEngine = new SimulationEngine(simulationList);
            simulationEngine.runAsync();

        } catch (IllegalArgumentException error) {
            infoLabel.setText("Incorrect input. Please enter f, l, r or b without unnecessary space.");
        }
    }

    private void prepareGrid(){
        for (int i = 0; i <MAP_SIZE; i++){
            ColumnConstraints column = new ColumnConstraints(CELL_SIZE);
            mapGrid.getColumnConstraints().add(column);
            RowConstraints row = new RowConstraints(CELL_SIZE);
            mapGrid.getRowConstraints().add(row);
            if(i == 0){
                mapGrid.add(createLabel("y\\x"), 0,0);
            } else {
                Label label = createLabel(Integer.toString(-MAP_SIZE/2+i));
                mapGrid.add(label, i, 0);
                Label rowLabel = createLabel(Integer.toString(-MAP_SIZE/2+i));
                mapGrid.add(rowLabel, 0, i);

            }
        }
    }
    private void cleanGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0)); // hack to retain visible grid lines
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }
    private Label createLabel(String text){
        Label label = new Label(text);
        GridPane.setHalignment(label, HPos.CENTER);
        return label;
    }

    private void drawAnimalPosition(String symbol, int positionX, int positionY){
        Label label = createLabel(symbol);
        int mapOffset = 5;
        mapGrid.add(label, positionX + mapOffset, positionY + mapOffset);
    }
}
