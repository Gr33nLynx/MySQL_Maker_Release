package com.greenlynx.mysqlmaker.dbmovements;

// ============= Imports =============
import com.greenlynx.mysqlmaker.dbstatus.DBStatus;
import com.greenlynx.mysqlmaker.helpers.Helper_Methods;
import java.sql.CallableStatement;
import java.sql.SQLException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	public static Button btnInsertExecution;
	public static HBox hFields;
	public static HBox hInsertExecution;
	public static HBox hTable;
	public static HBox hValues;
	public static Label lblFieldsToFill;
	public static Label lblTableToInsert;
	public static Label lblValuesToInsert;
	public static Scene insertScene;
	public static Stage insertStage;
	public static TextField txtFieldsToFill;
	public static TextField txtTableToInsert;
	public static TextField txtValuesToInsert;
	public static VBox vInsertBox;
	
	public static BorderPane updatePanel;
	public static Label lblConditionToApplyUpdate;
	public static Label lblNewValue;
	public static Label lblTableToUpdate;
	public static Label lblVariableToUpdate;
	public static Scene updateScene;
	public static Stage updateStage;
	
	public static BorderPane selectPanel;
	public static Label lblConditionToApplySelect;
	public static Label lblDataToRecover;
	public static Label lblTableToRecover;
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
		insertScene = new Scene(insertPanel, 400, 300);
		
		vInsertBox = new VBox();
		
		hTable = new HBox();
		lblTableToInsert = new Label("Table Name:");
		lblTableToInsert.setId("lblTableToInsert");
		txtTableToInsert = new TextField();
		hTable.setAlignment(Pos.CENTER);
		hTable.setSpacing(10);
		hTable.getChildren().addAll(lblTableToInsert, txtTableToInsert);
		
		hFields = new HBox();
		lblFieldsToFill = new Label("Fields:");
		lblFieldsToFill.setId("lblFieldsToFill");
		txtFieldsToFill = new TextField();
		hFields.setAlignment(Pos.CENTER);
		hFields.setPadding(new Insets(0, 0, 0, 47));
		hFields.setSpacing(10);
		hFields.getChildren().addAll(lblFieldsToFill, txtFieldsToFill);
		
		hValues = new HBox();
		lblValuesToInsert = new Label("Values:");
		lblValuesToInsert.setId("lblValuesToInsert");
		txtValuesToInsert = new TextField();
		hValues.setAlignment(Pos.CENTER);
		hValues.setPadding(new Insets(0, 0, 0, 41));
		hValues.setSpacing(10);
		hValues.getChildren().addAll(lblValuesToInsert, txtValuesToInsert);
		
		hInsertExecution = new HBox();
		btnInsertExecution = new Button("Execution!");
		btnInsertExecution.setOnMouseClicked(e -> InsertQueryAction());
		hInsertExecution.setAlignment(Pos.CENTER);
		hInsertExecution.setPadding(new Insets(20, 0, 0, 0));
		hInsertExecution.getChildren().addAll(btnInsertExecution);
		
		vInsertBox.setAlignment(Pos.CENTER);
		vInsertBox.getChildren().addAll(hTable, hFields, hValues, hInsertExecution);
		
		insertPanel.setCenter(vInsertBox);
		
		insertStage.setTitle("Insert Query Window");
		insertStage.setScene(insertScene);
		insertStage.setResizable(false);
		insertStage.getIcons().add(new Image("file:res/DBMovements_Insert.png"));
		insertScene.getStylesheets().add("file:styles/DBMovements.css");
		insertStage.show();
		Helper_Methods.CenterStage(insertStage);
	}
	
	public static void InsertQueryAction() {
		try {
			CallableStatement statement = DBStatus.DBLink.prepareCall("{ CALL sp_Insert (?, ?, ?) }");
			
			statement.execute();
			
			insertStage.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void SelectQuery() {
		selectStage = new Stage();
		selectPanel = new BorderPane();
		selectScene = new Scene(selectPanel, 600, 400);
		selectStage.setTitle("Select Query Window");
		selectStage.setScene(selectScene);
		selectStage.setResizable(false);
		selectStage.getIcons().add(new Image("file:res/DBMovements_Select.png"));
		selectStage.show();
		Helper_Methods.CenterStage(selectStage);
	}
	
	public static void SelectQueryAction() {
		try {
			CallableStatement statement = DBStatus.DBLink.prepareCall("{ CALL sp_Select (?, ?, ?) }");
			
			statement.execute();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void UpdateQuery() {
		updateStage = new Stage();
		updatePanel = new BorderPane();
		updateScene = new Scene(updatePanel, 600, 400);
		updateStage.setTitle("Update Query Window");
		updateStage.setScene(updateScene);
		updateStage.setResizable(false);
		updateStage.getIcons().add(new Image("file:res/DBMovements_Update.png"));
		updateStage.show();
		Helper_Methods.CenterStage(updateStage);
	}
	
	public static void UpdateQueryAction() {
		try {
			CallableStatement statement = DBStatus.DBLink.prepareCall("{ CALL sp_Update (?, ?, ?, ?) }");
			
			statement.execute();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void DeleteQuery() {
		deleteStage = new Stage();
		deletePanel = new BorderPane();
		deleteScene = new Scene(deletePanel, 600, 400);
		deleteStage.setTitle("Delete Query Window");
		deleteStage.setScene(deleteScene);
		deleteStage.setResizable(false);
		deleteStage.getIcons().add(new Image("file:res/DBMovements_Delete.png"));
		deleteStage.show();
		Helper_Methods.CenterStage(deleteStage);
	}
	
	public static void DeleteQueryAction() {
		try {
			CallableStatement statement = DBStatus.DBLink.prepareCall("{ CALL sp_Delete (?, ?, ?) }");
			
			statement.execute();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void ProcedureQuery() {
		procedureStage = new Stage();
		procedurePanel = new BorderPane();
		procedureScene = new Scene(procedurePanel, 600, 400);
		procedureStage.setTitle("Procedure Query Window");
		procedureStage.setScene(procedureScene);
		procedureStage.setResizable(false);
		procedureStage.getIcons().add(new Image("file:res/DBMovements_Procedure.png"));
		procedureStage.show();
		Helper_Methods.CenterStage(procedureStage);
	}
	
	public static void ProcedureQueryAction() {
		
	}
	
	public static void FunctionQuery() {
		functionStage = new Stage();
		functionPanel = new BorderPane();
		functionScene = new Scene(functionPanel, 600, 400);
		functionStage.setTitle("Function Query Window");
		functionStage.setScene(functionScene);
		functionStage.setResizable(false);
		functionStage.getIcons().add(new Image("file:res/DBMovements_Function.png"));
		functionStage.show();
		Helper_Methods.CenterStage(functionStage);
	}
	
	public static void FunctionQueryAction() {
		
	}
	
	public static void TriggerQuery() {
		triggerStage = new Stage();
		triggerPanel = new BorderPane();
		triggerScene = new Scene(triggerPanel, 600, 400);
		triggerStage.setTitle("Trigger Query Window");
		triggerStage.setScene(triggerScene);
		triggerStage.setResizable(false);
		triggerStage.getIcons().add(new Image("file:res/DBMovements_Trigger.png"));
		triggerStage.show();
		Helper_Methods.CenterStage(triggerStage);
	}
	
	public static void TriggerQueryAction() {
		
	}
	
}
