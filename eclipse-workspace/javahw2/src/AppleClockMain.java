/**
 * Created on Mar 9, 2018
 * @author cskim -- hufs.ac.kr, Dept of CES
 * Copy Right -- Free for Educational Purpose
 */
package javahw;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AppleClockMain extends Application {
	private static final int ROWS = 1;
	private static final int COLS = 2;
	double scrHeight = 600;
	double scrWidth = 600;
	int bwidth = 0;
	int bheight = 0;
	private GridPane root;
	

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		SeoulClockPane clock = new SeoulClockPane(); 
		VancouverClockPane clock2 = new VancouverClockPane();
		// Create a handler for animation
		EventHandler<ActionEvent> eventHandler = e -> {
			clock.setCurrentTime(); // Set a new clock time
			clock2.setCurrentTime();
		};

		// Create an animation for a running clock
		Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play(); // Start animation
		root = new GridPane();
		root.setPrefHeight(scrHeight);
		root.setPrefWidth(scrWidth);

		// Create a scene and place it in the stage

		initialize();

		Scene scene1 = new Scene(root);
		root.add(clock, 0, 0);
		root.add(clock2,1 ,0);
		primaryStage.setTitle("World Clock"); // Set the stage title
		primaryStage.setScene(scene1); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	void initialize() {
		for (int row = 0 ; row < ROWS ; row++ ){
			RowConstraints rc = new RowConstraints();
			rc.setFillHeight(true);
			rc.setVgrow(Priority.ALWAYS);
			root.getRowConstraints().add(rc);
		}
		for (int col = 0 ; col < COLS; col++ ) {
			ColumnConstraints cc = new ColumnConstraints();
			cc.setFillWidth(true);
			cc.setHgrow(Priority.ALWAYS);
			root.getColumnConstraints().add(cc);
		}
	}
	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
