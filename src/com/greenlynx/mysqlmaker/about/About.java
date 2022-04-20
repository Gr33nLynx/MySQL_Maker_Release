package com.greenlynx.mysqlmaker.about;

import java.io.IOException;

// ============= Imports =============
import com.greenlynx.mysqlmaker.helpers.Helper_Methods;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
// ===================================

/**
 * <b>PROJECT NAME:</b><br> 
 * &nbsp;&nbsp;&nbsp;&nbsp;MySQL Maker<br>
 * <b>PROJECT DESCRIPTION:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;GUI for the creation of MySQL code in an automated way<br>
 * <b>FILE NAME:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;About.java<br>
 * <b>FILE DESCRIPTION:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;Application's About Window's Class<br>
 * <b>NOTES:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;All plagiarism attempts // Code theft will be reported by the 
 * &nbsp;&nbsp;&nbsp;&nbsp;author<br>
 * <b>COPYRIGHT:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;©2022 GR33NLYNX
 * @author GR33NLYNX
 * @version 1.0
 */
public class About {
	
	// ======= Attributes =======
		public static BorderPane AboutPanel;
		public static HBox hBottomImage;
		public static HBox hCenter;
		public static HBox hDonation;
		public static HBox hTop;
		public static Image imgDonation;
		public static ImageView ivDonation;
		public static Label lblDescription;
		public static Label lblDonation;
		public static Label lblTitle;
		public static Scene AboutScene;
		public static Stage AboutStage;
		public static VBox vBottom;
	// ==========================
	
	/**
	 * Help Window's Loader
	 * @throws IOException 
	 */
	public static void AboutWindowLoader() {
		AboutStage = new Stage();
		AboutPanel = new BorderPane();
		AboutScene = new Scene(AboutPanel, 600, 300);
		
		hTop = new HBox();
		lblTitle = new Label("Hello from GreenLynx!");
		lblTitle.setId("lblTitle");
		hTop.setPadding(new Insets(20, 0, 0, 15));
		hTop.getChildren().add(lblTitle);
		
		hCenter = new HBox();
		lblDescription = new Label
				("I am pleased to present to you, dear user, my first software.\n"
				+ "It is called 'MySQL Maker' and its functionality is very simple.\n\n"
				+ "It is a program, which uses a graphical interface to write\n MySQL code in a totally automatic way.");
		lblDescription.setId("lblDescription");
		lblDescription.setTextAlignment(TextAlignment.RIGHT);
		hCenter.setAlignment(Pos.TOP_RIGHT);
		hCenter.setPadding(new Insets(20, 20, 0, 0));
		hCenter.getChildren().add(lblDescription);
		
		vBottom = new VBox();
		
		hDonation = new HBox();
		lblDonation = new Label
				("If you want to offer a donation for future improvements,\nclick on the image to make it");
		lblDonation.setId("lblDonation");
		
		hDonation.setAlignment(Pos.TOP_LEFT);
		hDonation.setPadding(new Insets(-90, 0, 0, 20));
		hDonation.getChildren().addAll(lblDonation);
		
		hBottomImage = new HBox();
		imgDonation = new Image("file:res/AboutWindow_Donation.png");
		ivDonation = new ImageView(imgDonation);
		ivDonation.setFitWidth(150);
		ivDonation.setFitHeight(50);
		ivDonation.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				
			}
			
		});
		hBottomImage.setPadding(new Insets(-60, 0, 0, 240));
		hBottomImage.getChildren().addAll(ivDonation);
		
		vBottom.getChildren().addAll(hDonation, hBottomImage);
		
		AboutPanel.setTop(hTop);
		AboutPanel.setCenter(hCenter);
		AboutPanel.setBottom(vBottom);
		
		AboutStage.setTitle("About MySQL Maker");
		AboutStage.setScene(AboutScene);
		AboutStage.setResizable(false);
		AboutStage.getIcons().add(new Image("file:res/AboutWindow_Icon.png"));
		AboutScene.getStylesheets().add("file:styles/AboutWindow.css");
		
		AboutStage.show();
		Helper_Methods.CenterStage(AboutStage);
	}
}