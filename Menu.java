package mini_metro.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;

/*
        Menu for Space Invader Game

        ** Nothing to do here **
 */
public class Menu extends MenuBar {

    public Menu(EventHandler<ActionEvent> menuHandler) {

        javafx.scene.control.Menu menuFile = createMenuFile();

        // Add event handling for all menu items
        menuFile.getItems().forEach(item -> item.setOnAction(menuHandler));

        this.getMenus().addAll(menuFile);
    }

    // TODO Fix selected
    private javafx.scene.control.Menu createMenuFile() {
        javafx.scene.control.Menu menuFile = new javafx.scene.control.Menu("File");
        MenuItem newItem = new MenuItem("New");
        MenuItem stopItem = new MenuItem("Stop");
        MenuItem exitItem = new MenuItem("Exit");
        menuFile.getItems().addAll(newItem, stopItem, exitItem);
        return menuFile;
    }

}
