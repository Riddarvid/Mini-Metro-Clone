package mini_metro.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;

public class Menu extends MenuBar {

    public Menu(EventHandler<ActionEvent> menuHandler) {

        javafx.scene.control.Menu menuFile = createMenuFile();

        menuFile.getItems().forEach(item -> item.setOnAction(menuHandler));

        this.getMenus().addAll(menuFile);
    }

    private javafx.scene.control.Menu createMenuFile() {
        javafx.scene.control.Menu menuFile = new javafx.scene.control.Menu("File");
        MenuItem newItem = new MenuItem("New");
        MenuItem stopItem = new MenuItem("Stop");
        MenuItem exitItem = new MenuItem("Exit");
        menuFile.getItems().addAll(newItem, stopItem, exitItem);
        return menuFile;
    }

}
