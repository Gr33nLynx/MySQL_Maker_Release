package com.greenlynx.mysqlmaker.dbmovements;

// ============= Imports =============
import com.greenlynx.mysqlmaker.helpers.Helper_Methods;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
// ===================================

/**
 * <b>PROJECT NAME:</b><br> 
 * &nbsp;&nbsp;&nbsp;&nbsp;MySQL Maker<br>
 * <b>PROJECT DESCRIPTION:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;GUI for the creation of MySQL code in an automated way<br>
 * <b>FILE NAME:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;DBMovements.java<br>
 * <b>FILE DESCRIPTION:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;DB Movements Matters Class<br>
 * <b>NOTES:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;All plagiarism attempts // Code theft will be reported by the 
 * &nbsp;&nbsp;&nbsp;&nbsp;author<br>
 * <b>COPYRIGHT:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;©2022 GR33NLYNX
 * @author GR33NLYNX
 * @version 1.0
 */
public class DBMovements {

	// ======= Attributes =======
	public static BorderPane insertPanel;
	public static Scene insertScene;
	public static Stage insertStage;
	
	public static BorderPane updatePanel;
	public static Scene updateScene;
	public static Stage updateStage;
	
	public static BorderPane selectPanel;
	public static Scene selectScene;
	public static Stage selectStage;
	
	public static BorderPane deletePanel;
	public static Scene deleteScene;
	public static Stage deleteStage;

	public static BorderPane procedurePanel;
	public static Scene procedureScene;
	public static Stage procedureStage;
	
	public static BorderPane functionPanel;
	public static Scene functionScene;
	public static Stage functionStage;
	
	public static BorderPane triggerPanel;
	public static Scene triggerScene;
	public static Stage triggerStage;
	// ==========================
	
	public static void InsertQuery() {
		insertStage = new Stage();
		insertPanel = new BorderPane();
		insertScene = new Scene(insertPanel, 600, 400);
		insertStage.setTitle("Insert Query Window");
		insertStage.setScene(insertScene);
		insertStage.setResizable(false);
		insertStage.getIcons().add(new Image("file:res/DBMovements_Insert.png"));
		//insertScene.getStylesheets().add("file:styles/insertWindow.css");
		insertStage.show();
		Helper_Methods.CenterStage(insertStage);
	}
	
	public static void SelectQuery() {
		selectStage = new Stage();
		selectPanel = new BorderPane();
		selectScene = new Scene(selectPanel, 600, 400);
		selectStage.setTitle("Select Query Window");
		selectStage.setScene(selectScene);
		selectStage.setResizable(false);
		selectStage.getIcons().add(new Image("file:res/DBMovements_Select.png"));
		selectScene.getStylesheets().add("file:res/DBMovements_Select.css");
		selectStage.show();
		Helper_Methods.CenterStage(selectStage);
	}
	
	public static void UpdateQuery() {
		updateStage = new Stage();
		updatePanel = new BorderPane();
		updateScene = new Scene(updatePanel, 600, 400);
		updateStage.setTitle("Update Query Window");
		updateStage.setScene(updateScene);
		updateStage.setResizable(false);
		updateStage.getIcons().add(new Image("file:res/DBMovements_Update.png"));
		updateScene.getStylesheets().add("file:res/DBMovements_Update.css");
		updateStage.show();
		Helper_Methods.CenterStage(updateStage);
	}
	
	public static void DeleteQuery() {
		deleteStage = new Stage();
		deletePanel = new BorderPane();
		deleteScene = new Scene(deletePanel, 600, 400);
		deleteStage.setTitle("Delete Query Window");
		deleteStage.setScene(deleteScene);
		deleteStage.setResizable(false);
		deleteStage.getIcons().add(new Image("file:res/DBMovements_Delete.png"));
		deleteScene.getStylesheets().add("file:res/DBMovements_Delete.css");
		deleteStage.show();
		Helper_Methods.CenterStage(deleteStage);
	}
	
	public static void ProcedureQuery() {
		procedureStage = new Stage();
		procedurePanel = new BorderPane();
		procedureScene = new Scene(procedurePanel, 600, 400);
		procedureStage.setTitle("Procedure Query Window");
		procedureStage.setScene(procedureScene);
		procedureStage.setResizable(false);
		procedureStage.getIcons().add(new Image("file:res/DBMovements_Procedure.png"));
		procedureScene.getStylesheets().add("file:styles/DBMovements_Procedure.css");
		procedureStage.show();
		Helper_Methods.CenterStage(procedureStage);
	}
	
	public static void FunctionQuery() {
		functionStage = new Stage();
		functionPanel = new BorderPane();
		functionScene = new Scene(functionPanel, 600, 400);
		functionStage.setTitle("Function Query Window");
		functionStage.setScene(functionScene);
		functionStage.setResizable(false);
		functionStage.getIcons().add(new Image("file:res/DBMovements_Function.png"));
		functionScene.getStylesheets().add("file:styles/DBMovements_Function.css");
		functionStage.show();
		Helper_Methods.CenterStage(functionStage);
	}
	
	public static void TriggerQuery() {
		triggerStage = new Stage();
		triggerPanel = new BorderPane();
		triggerScene = new Scene(triggerPanel, 600, 400);
		triggerStage.setTitle("Trigger Query Window");
		triggerStage.setScene(triggerScene);
		triggerStage.setResizable(false);
		triggerStage.getIcons().add(new Image("file:res/DBMovements_Trigger.png"));
		triggerScene.getStylesheets().add("file:styles/DBMovements_Trigger.css");
		triggerStage.show();
		Helper_Methods.CenterStage(triggerStage);
	}
	
}
