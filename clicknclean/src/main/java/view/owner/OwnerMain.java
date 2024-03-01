package view.owner;

import view.SceneId;
import view.Window;
import java.io.File;

import controller.owner.OwnerProfileController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class OwnerMain {
public OwnerMain(Window window) {
		
		window.setTitle("Accueil de Propriétaire");
		
		Label welcomeMessage = new Label("Bienvenu "+Window.currentOwner.getName()+" !");
		Label missionInProgress = new Label("Vos missions en cours :");
		Label missionCome = new Label("Vos missions à venir");
		
		TableView tableViewMissionCome = new TableView();

	    TableColumn column1 = new TableColumn("Date et heure");
	    TableColumn column2 = new TableColumn("Durée");
	    TableColumn column3 = new TableColumn("Cleaner");
	    
	    tableViewMissionCome.getColumns().add(column1);
	    tableViewMissionCome.getColumns().add(column2);
	    tableViewMissionCome.getColumns().add(column3);
		
		TableView tableViewMissionInprogress = new TableView();

	    TableColumn column1p = new TableColumn("Date et heure");
	    TableColumn column2p = new TableColumn("Durée");
	    TableColumn column3p = new TableColumn("Cleaner");
	    
	    tableViewMissionInprogress.getColumns().add(column1p);
	    tableViewMissionInprogress.getColumns().add(column2p);
	    tableViewMissionInprogress.getColumns().add(column3p);
		
		MenuBar bar = new MenuBar();
		Menu profile = new Menu("Profil");
		Menu property = new Menu("Propriétés");
		Menu mission = new Menu("Mission");
		
		 
		MenuItem seeProfile = new MenuItem("Voir le profil");
		MenuItem disconnect = new MenuItem("Déconnexon");
		
		MenuItem seeProperty = new MenuItem("Voir les Propriétés");
		MenuItem addProperty = new MenuItem("Nouvelle Propriété");
		
		MenuItem seeMission = new MenuItem("Voir les Missions");
		MenuItem addMission = new MenuItem("Proposer une Mission");
		
		
		
		profile.getItems().addAll(seeProfile, disconnect);
		property.getItems().addAll(seeProperty, addProperty);
		mission.getItems().addAll(seeMission, addMission);
		bar.getMenus().addAll(profile, property, mission);
		

		
		EventHandler<ActionEvent> eventDisconnect = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				window.setScene(SceneId.CONNECTION);
				//disconnectController? see for right
			}

		};
		disconnect.setOnAction(eventDisconnect);
		
		EventHandler<ActionEvent> eventViewProfil = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				new OwnerProfileController(window);
			}
		};
		seeProfile.setOnAction(eventViewProfil);
		
		
		VBox vbox = new VBox();
		vbox.getChildren().add(bar);
		vbox.getChildren().add(welcomeMessage);
		vbox.getChildren().add(missionInProgress);
		vbox.getChildren().add(tableViewMissionInprogress);
		vbox.getChildren().add(missionCome);
		vbox.getChildren().add(tableViewMissionCome);
		
		
		
		tableViewMissionCome.setMaxHeight(150);
		tableViewMissionCome.setMaxWidth(500);
		tableViewMissionInprogress.setMaxHeight(150);
		tableViewMissionInprogress.setMaxWidth(500);
		
		
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(100, 300, 20, 300));
		vbox.setAlignment(Pos.TOP_CENTER);

		ScrollPane scrollPane = new ScrollPane();
	    scrollPane.setContent(vbox);

	    scrollPane.setPannable(true);
	    scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
	    scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);

	    Scene scene = new Scene(scrollPane, 800, 600);
	    scene.getStylesheets().add("file:///" + new File("src/main/css/style.css").getAbsolutePath().replace("\\", "/"));
	    window.setScene(scene);
	}
}
