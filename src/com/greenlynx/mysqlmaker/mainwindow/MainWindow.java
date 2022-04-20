package com.greenlynx.mysqlmaker.mainwindow;

// ============= Imports =============
import com.greenlynx.mysqlmaker.about.About;
import com.greenlynx.mysqlmaker.dbstatus.DBStatus;
import com.greenlynx.mysqlmaker.helpers.Helper_Methods;
import com.greenlynx.mysqlmaker.trial.Trial;
import java.io.IOException;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
// ===================================

/**
 * <b>PROJECT NAME:</b><br> 
 * &nbsp;&nbsp;&nbsp;&nbsp;MySQL Maker<br>
 * <b>PROJECT DESCRIPTION:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;GUI for the creation of MySQL code in an automated way<br>
 * <b>FILE NAME:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;MainWindow.java<br>
 * <b>FILE DESCRIPTION:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;Application's Main Window's Class<br>
 * <b>NOTES:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;All plagiarism attempts // Code theft will be reported by the 
 * &nbsp;&nbsp;&nbsp;&nbsp;author<br>
 * <b>COPYRIGHT:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;©2022 GR33NLYNX
 * @author GR33NLYNX
 * @version 1.0
 */
public class MainWindow {
	
	// ======= Attributes =======
	public static BorderPane bottomPanel;
	public static BorderPane centerPanel;
	public static BorderPane centerTopPanel;
	public static BorderPane mainPanel;
	public static BorderPane mainWindow;
	public static HBox bottomLeftPanel;
	public static HBox bottomRightPanel;
	public static HBox hCenterTopLeftPanel;
	public static HBox hCenterTopRightPanel;
	public static Label lblCreator;
	public static Label lblCreatorText;
	public static Label lblStatus;
	public static Label lblStatusText;
	public static Label lblTitle;
	public static Label lblVersion;
	public static Label lblVersionText;
	public static Menu helpMenu;
	public static Menu mysqlMenu;
	public static Menu toolsMenu;
	public static Menu toolsAdvancedMenu;
	public static Menu toolsSimpleMenu;
	public static MenuBar topBar;
	public static MenuItem helpAbout;
	public static MenuItem mysqlConnect;
	public static MenuItem mysqlDisconnect;
	public static MenuItem toolsDelete;
	public static MenuItem toolsInsert;
	public static MenuItem toolsSelect;
	public static MenuItem toolsUpdate;
	public static Scene mainScene;
	public static Stage mainStage;
	// ==========================
		
	/**
	 * Main Window's Loader
	 * @throws IOException
	 */
	public static void MainWindowLoader() throws IOException {
		if (!Trial.TrialChecker()) {
			if (!Trial.SystemTimeModify()) {
				if (!Trial.ConfigFileModify()) {
					mainStage = new Stage();
					mainPanel = MainWindowConfig();
					mainScene = new Scene(mainPanel, 800, 400);
					mainStage.setTitle("MySQL Maker");
					mainStage.setScene(mainScene);
					mainStage.setResizable(false);
					mainStage.getIcons().add(new Image("file:res/MainWindow_Icon.png"));
					mainScene.getStylesheets().add("file:styles/MainWindow.css");
					mainStage.show();
					Helper_Methods.CenterStage(mainStage);
					mainStage.setOnCloseRequest(e -> Platform.exit());
				}
				else {
					Helper_Methods.ErrorStage(300, 150, "CHEATS ARE NOT ALLOWED!",
														"GOT YA CHEATER",
														"The system has detected that you have modified the configuration files! Exiting...",
														new Image("file:res/ErrorWindow_StopCheater.png"));
				}
			}
			else {
				Helper_Methods.ErrorStage(300, 150, "CHEATS ARE NOT ALLOWED!",
													"GOT YA CHEATER",
													"The system has detected that you have modified the system's clock! Exiting...",
													new Image("file:res/ErrorWindow_StopCheater.png"));
			}
		}
		else {
			Trial.TrialFinisher();
		}
	}

	/**
	 * Main Window's Configurator
	 * @return mainWindow
	 */
	public static BorderPane MainWindowConfig() {
		mainWindow = new BorderPane();
		mainWindow.setTop(TopSite());
		mainWindow.setCenter(CenterSite());
		mainWindow.setBottom(BottomSite());
		return mainWindow;
	}
	
	/**
	 * Main Window's Top Site
	 * @return topBar
	 */
	public static MenuBar TopSite() {
		topBar = new MenuBar();
		mysqlMenu = new Menu("MySQL");
		mysqlConnect = new MenuItem("Connect to DB");
		mysqlConnect.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));
		mysqlConnect.setOnAction(e -> DBStatus.MySQLStatus());
		mysqlDisconnect = new MenuItem("Disconnect from DB");
		mysqlDisconnect.setAccelerator(new KeyCodeCombination(KeyCode.D, KeyCombination.CONTROL_DOWN));
		mysqlDisconnect.setOnAction(e -> DBStatus.DBDisconnection());
		mysqlDisconnect.setDisable(true);
		mysqlMenu.getItems().addAll(mysqlConnect, mysqlDisconnect);
		
		toolsMenu = new Menu("Tools");
		toolsSimpleMenu = new Menu("Simple Queries");
		toolsInsert = new MenuItem("INSERT query");
		toolsInsert.setDisable(true);
		toolsSelect = new MenuItem("SELECT query");
		toolsSelect.setDisable(true);
		toolsUpdate = new MenuItem("UPDATE query");
		toolsUpdate.setDisable(true);
		toolsDelete = new MenuItem("DELETE query");
		toolsDelete.setDisable(true);
		toolsSimpleMenu.getItems().addAll(toolsInsert, toolsSelect, toolsUpdate, toolsDelete);
		toolsAdvancedMenu = new Menu("Advanced Queries");
		toolsMenu.getItems().addAll(toolsSimpleMenu, toolsAdvancedMenu);
		
		helpMenu = new Menu("Help");
		helpAbout = new MenuItem("About MySQL Maker");
		helpAbout.setOnAction(e -> About.AboutWindowLoader());
		helpMenu.getItems().add(helpAbout);
		
		topBar.getMenus().addAll(mysqlMenu, toolsMenu, helpMenu);
		
		return topBar;
	}
	
	/**
	 * Main Window's Center Site
	 * @return 
	 */
	public static BorderPane CenterSite() {
		centerPanel = new BorderPane();
		
		centerTopPanel = new BorderPane();
		
		hCenterTopLeftPanel = new HBox();
		lblTitle = new Label("MySQL Maker");
		
		hCenterTopRightPanel = new HBox();
		lblStatus = new Label("Status: ");
		lblStatusText = new Label("OFF");
		
		lblTitle.setId("lblTitle");
		hCenterTopLeftPanel.getChildren().add(lblTitle);
		hCenterTopLeftPanel.setPadding(new Insets(10, 0, 0, 20));
		
		lblStatus.setId("lblStatus");
		lblStatusText.setId("lblStatusText");
		hCenterTopRightPanel.getChildren().addAll(lblStatus, lblStatusText);
		hCenterTopRightPanel.setPadding(new Insets(10, 20, 0, 0));
		
		centerTopPanel.setLeft(hCenterTopLeftPanel);
		centerTopPanel.setRight(hCenterTopRightPanel);
		centerPanel.setTop(centerTopPanel);
		
		return centerPanel;
	}
	
	/**
	 * Main Window's Bottom Site
	 * @return bottomPanel
	 */
	public static BorderPane BottomSite() {
		bottomPanel = new BorderPane();
		
		bottomLeftPanel = new HBox();
		lblCreator = new Label("Creator: ");
		lblCreatorText = new Label("Gr33nLynx");
		
		bottomRightPanel = new HBox();
		lblVersion = new Label("Version: ");
		lblVersionText = new Label("1.0");
		
		lblCreator.setId("lblCreator");
		lblCreatorText.setId("lblCreatorText");
		
		lblVersion.setId("lblVersion");
		lblVersionText.setId("lblVersionText");
		
		bottomLeftPanel.getChildren().addAll(lblCreator, lblCreatorText);
		bottomRightPanel.getChildren().addAll(lblVersion, lblVersionText);
		
		bottomPanel.setLeft(bottomLeftPanel);
		bottomPanel.setRight(bottomRightPanel);
		BorderPane.setMargin(bottomPanel, new Insets(0, 5, 0, 5));
		
		return bottomPanel;
	}
	
}