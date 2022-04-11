package com.greenlynx.mysqlmaker.helpers;

// ============= Imports =============
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
// ===================================

/**
 * <b>PROJECT NAME:</b><br> 
 * &nbsp;&nbsp;&nbsp;&nbsp;MySQL Maker<br>
 * <b>PROJECT DESCRIPTION:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;GUI for the creation of MySQL code in an automated way<br>
 * <b>FILE NAME:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;Helper_Methods.java<br>
 * <b>FILE DESCRIPTION:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;Some helper methods for the application<br>
 * <b>NOTES:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;All plagiarism attempts // Code theft will be reported by the 
 * &nbsp;&nbsp;&nbsp;&nbsp;author<br>
 * <b>COPYRIGHT:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;©2022 GR33NLYNX
 * @author GR33NLYNX
 * @version 1.0
 */
public class Helper_Methods {
	
	// ======= Attributes =======
	public static BorderPane errorPanel;
	public static Label lblErrorDescription;
	public static Label lblErrorTitle;
	public static Scene errorScene;
	public static Stage errorStage;
	public static VBox vErrorInfo;
	// ==========================
	
	/**
	 * Center any stage on the middle of the screen
	 * @param arg0
	 */
	public static void CenterStage(Stage arg0) {
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		arg0.setX((primScreenBounds.getWidth() - arg0.getWidth()) / 2);
		arg0.setY((primScreenBounds.getHeight() - arg0.getHeight()) / 2);
	}
	
	/**
	 * Customized Error Window
	 * @param errorTitle
	 * @param errorDescription
	 * @param errorIcon
	 */
	public static void ErrorStage(int width,
								  int height,
								  String errorTitle, 
								  String errorInternalTitle,
								  String errorInternalDescription,
								  Image errorIcon) {
		errorStage = new Stage();
		errorPanel = new BorderPane();
		errorScene = new Scene(errorPanel, width, height);
		
		vErrorInfo = new VBox();
		lblErrorTitle = new Label(errorInternalTitle);
		lblErrorDescription = new Label(errorInternalDescription);
		
		lblErrorTitle.setId("lblErrorTitle");
		lblErrorDescription.setId("lblErrorDescription");

		vErrorInfo.setSpacing(10);
		vErrorInfo.getChildren().addAll(lblErrorTitle, lblErrorDescription);
		
		errorStage.setTitle(errorTitle);
		errorStage.setScene(errorScene);
		errorStage.setResizable(false);
		errorStage.getIcons().add(errorIcon);
		vErrorInfo.setAlignment(Pos.CENTER);
		errorPanel.setCenter(vErrorInfo);
		errorScene.getStylesheets().add("file:styles/ErrorWindow.css");
		
		errorStage.show();
		CenterStage(errorStage);
		
		PauseTransition delay = new PauseTransition(Duration.seconds(3));
		delay.setOnFinished(e -> errorStage.close());
		delay.play();
	}
}