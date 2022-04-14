package com.greenlynx.mysqlmaker.dbcreds;

// ============= Imports =============
import com.greenlynx.mysqlmaker.dbstatus.DBStatus;
import com.greenlynx.mysqlmaker.helpers.Helper_Methods;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
// ===================================

/**
 * <b>PROJECT NAME:</b><br> 
 * &nbsp;&nbsp;&nbsp;&nbsp;MySQL Maker<br>
 * <b>PROJECT DESCRIPTION:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;GUI for the creation of MySQL code in an automated way<br>
 * <b>FILE NAME:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;DBCreds.java<br>
 * <b>FILE DESCRIPTION:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;DB Credentials Checker Class<br>
 * <b>NOTES:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;All plagiarism attempts // Code theft will be reported by the 
 * &nbsp;&nbsp;&nbsp;&nbsp;author<br>
 * <b>COPYRIGHT:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;©2022 GR33NLYNX
 * @author GR33NLYNX
 * @version 1.0
 */
public class DBCreds {
	
	// ======= Attributes =======
	public static BorderPane DBPanel;
	public static Button btnAccept;
	public static HBox hButton;
	public static HBox hDB;
	public static HBox hPassword;
	public static HBox hUser;
	public static Label lblDB;
	public static Label lblPassword;
	public static Label lblUser;
	public static PasswordField txtPassword;
	public static Scene DBScene;
	public static Stage DBStage;
	public static TextField txtDB;
	public static TextField txtUser;
	public static VBox vCredentials;
	// ==========================
	
	/**
	 * User Credentials Window
	 */
	public static void DBCredentials() {
		DBStage = new Stage();
		DBPanel = new BorderPane();
		DBScene = new Scene(DBPanel, 300, 150);
		
		vCredentials = new VBox();
		
		hUser = new HBox();
		lblUser = new Label("Username: ");
		txtUser = new TextField();
		
		hPassword = new HBox();
		lblPassword = new Label("Password: ");
		txtPassword = new PasswordField();
		
		hDB = new HBox();
		lblDB = new Label("DB: ");
		txtDB = new TextField();
		
		hButton = new HBox();
		btnAccept = new Button("Login");
		
		lblUser.setId("lblUser");
		txtUser.requestFocus();
		hUser.setAlignment(Pos.CENTER);
		hUser.getChildren().addAll(lblUser, txtUser);
		
		lblPassword.setId("lblPassword");
		hPassword.setAlignment(Pos.CENTER);
		hPassword.getChildren().addAll(lblPassword, txtPassword);
		
		lblDB.setId("lblDB");
		hDB.setAlignment(Pos.CENTER);
		hDB.getChildren().addAll(lblDB, txtDB);
		
		btnAccept.setPrefSize(100, 10);
		btnAccept.setOnAction(e -> DBStatus.DBConnection());
		hButton.setAlignment(Pos.CENTER);
		hButton.getChildren().add(btnAccept);
		hButton.setPadding(new Insets(5,0,0,0));
		
		vCredentials.setAlignment(Pos.CENTER);
		vCredentials.setSpacing(5);
		vCredentials.getChildren().addAll(hUser, hPassword, hDB, hButton);
		
		DBStage.setTitle("Login Credentials");
		DBStage.setScene(DBScene);
		DBPanel.setCenter(vCredentials);
		DBStage.setResizable(false);
		DBStage.getIcons().add(new Image("file:res/DBWindow_Icon.png"));
		DBScene.getStylesheets().add("file:styles/DBWindow.css");
		
		DBStage.show();
		Helper_Methods.CenterStage(DBStage);
	}
	
}