package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.presenter.SimulationPresenter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.List;

public class SimulationApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("simulation.fxml"));
        BorderPane viewRoot = loader.load();
        SimulationPresenter presenter = loader.getController();
        configureStage(primaryStage, viewRoot);

        List<String> args = getParameters().getRaw();
        List<MoveDirection> directions = OptionsParser.parse(args.toArray(new String[0]));
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
        RectangularMap rectangularMap = new RectangularMap(4,4);
        presenter.setWorldMap(rectangularMap);
        rectangularMap.addObserver(presenter);
        Simulation simulation = new Simulation(rectangularMap, positions, directions);
        simulation.run();

    }

    private void configureStage(Stage primaryStage, BorderPane viewRoot) {
        var scene = new Scene(viewRoot);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simulation app");
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty());
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty());
    }
}
