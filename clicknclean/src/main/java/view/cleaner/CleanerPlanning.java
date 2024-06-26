package view.cleaner;

import view.Window;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controller.cleaner.CleanerConnected;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import model.Cleaner;
import model.Mission;
import model.planning.TimeSlot;
import tools.Db;

public class CleanerPlanning extends Scene {
    public CleanerPlanning(VBox container, Window window, Cleaner cleaner) {
        super(container, 800, 600);
        window.setTitle("Planning view");
        System.out.println("CleanerPlanning constructor");
        Button backButton = new Button("Back");

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ev) {
               	try {
					new CleanerConnected(new VBox(), window, cleaner, 0);
				} catch (Exception e) {
					System.err.println("Couldn't call the next controller for error : " + e);
				}
            }
        });

        ListView<VBox> menu = new ListView<VBox>();

        for (TimeSlot t : cleaner.getPlanning().getTimeSlots()) {
            VBox global = new VBox();

            HBox title = new HBox();

            Label titleLabel = new Label(t.getLocalDateTime().getDayOfMonth() + " "
                                         + t.getLocalDateTime().getMonth().toString().toLowerCase()
                                         + " à " + t.getLocalDateTime().getHour() + ":" + t.getLocalDateTime().getMinute() + " pendant "
                                         + t.getDurationH() + " heures");

            Button updateButton = new Button("Fetch mission");
            Label main = new Label(t.getIdMission() + "");

            updateButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent ev) {
                    if (t.getIdMission() == -1) {
                        System.out.println("Mission id is -1, cancel fetch");
                        return;
                    }
                    Db db  = new Db();
                    Mission mission;
                    try {
                        mission = db.DAOReadMission(t.getIdMission());
                    } catch (Exception e) {
                        System.err.println("[ERROR] An error occured while fetching mission" + t.getIdMission() + " from db : " + e);
                        return;
                    }

                    System.out.println(mission.toString());
                }
            });

            title.getChildren().addAll(titleLabel);

            global.getChildren().addAll(title, main);
            global.getChildren().add(updateButton);

            menu.getItems().add(global);
        }

        container.getChildren().addAll(backButton, menu);

        // container.addAll(backButton, menu);

        this.getStylesheets()
        .add("file:///" + new File("src/main/css/style.css").getAbsolutePath().replace("\\", "/"));

    }
}