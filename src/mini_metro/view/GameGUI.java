package mini_metro.view;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import mini_metro.model.Line;
import mini_metro.model.Station;
import mini_metro.model.Train;
import mini_metro.model.World;
import mini_metro.model.levels.ILevel;
import mini_metro.model.levels.Level0;
import mini_metro.event.*;
import static mini_metro.model.World.GAME_WIDTH;
import static mini_metro.model.World.GAME_HEIGHT;


public class GameGUI extends Application {


    private World world;
    private boolean running = false;


    //Menu handling

    private void handleMenu(ActionEvent e) {
        MenuItem mi = (MenuItem) e.getSource();
        switch (mi.getText()) {
            case "New":
                newGame();
                break;
            case "Stop":
                stopGame();
                break;
            case "Exit":
                System.exit(0);
                break;
            default:
        }
    }

    //Menu actions

    private void newGame() {

        world = new World(new Level0());

        timer.start();

        running = true;
    }

    private void stopGame() {
        running = false;
        timer.stop();
    }


    //Event handling

    private void handleModelEvent(Event evt) {
        if (evt.type == Event.Type.GAME_OVER) {

        }
    }

    //Rendering

    private AnimationTimer timer;
    private GraphicsContext fg;   // Foreground
    private GraphicsContext bg;   // Background
    private Menu menuBar;

    private void render() {
        fg.clearRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        renderLines();
        renderStations();
        renderTrains();
    }

    private void renderStations(){
        fg.setFill(Color.GREEN);
        fg.setFont(new Font(10));
        for (Station s:world.getStations()){
            fg.fillOval(s.getX(), s.getY(), s.getWidth(), s.getHeight());
            fg.fillText(s.getName(), s.getX()+s.getWidth(), s.getY()+s.getHeight()*2);
        }
    }

    private void renderLines(){
        Color[] colors={Color.YELLOW, Color.RED, Color.PURPLE, Color.BLUE};
        for (int i=0; i<world.getLines().size(); i++){
            renderLine(world.getLines().get(i), colors[i]);
        }
    }

    private void renderLine(Line l, Color color) {
        fg.setStroke(color);
        fg.setLineWidth(5);
        for (int i=0; i<l.getStations().size()-1; i++){
            Station s1=l.getStations().get(i);
            Station s2=l.getStations().get(i+1);
            fg.strokeLine(s1.getX()+s1.getWidth()/2, s1.getY()+s1.getHeight()/2, s2.getX()+s2.getWidth()/2, s2.getY()+s2.getHeight()/2);
        }
    }

    private void renderTrains(){
        fg.setFill(Color.BLACK);
        for (Train t:world.getTrains()){
            fg.fillRect(t.getX()+Station.getDiameter()/2-t.getWidth()/2, t.getY()+Station.getDiameter()/2-t.getHeight()/2, t.getWidth(), t.getHeight());
        }
    }


    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();

        // Menu
        menuBar = new Menu(this::handleMenu);
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        root.setTop(menuBar);

        // Drawing areas
        Canvas backGround = new Canvas(GAME_WIDTH, GAME_HEIGHT);
        bg = backGround.getGraphicsContext2D();
        Canvas foreGround = new Canvas(GAME_WIDTH, GAME_HEIGHT);
        fg = foreGround.getGraphicsContext2D();

        Pane pane = new Pane(backGround, foreGround);
        root.setCenter(pane);

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                world.update(now);
                render();
                Event e = EventService.remove();
                if (e != null) {
                    GameGUI.this.handleModelEvent(e);
                }

            }
        };

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Mini Metro");

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
