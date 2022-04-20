package com.greenlynx.mysqlmaker.about;

import java.io.IOException;

// ============= Imports =============
import com.greenlynx.mysqlmaker.helpers.Helper_Methods;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
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
		public static Scene AboutScene;
		public static Stage AboutStage;
	// ==========================
	
	/**
	 * Help Window's Loader
	 * @throws IOException 
	 */
	public static void AboutWindowLoader() {
		AboutStage = new Stage();
		AboutPanel = new BorderPane();
		AboutScene = new Scene(AboutPanel, 600, 300);
		
		AboutStage.setTitle("About MySQL Maker");
		AboutStage.setScene(AboutScene);
		AboutStage.setResizable(false);
		AboutStage.getIcons().add(new Image("file:res/AboutWindow_Icon.png"));
		AboutScene.getStylesheets().add("file:styles/AboutWindow.css");
		
		AboutStage.show();
		Helper_Methods.CenterStage(AboutStage);
	}
}