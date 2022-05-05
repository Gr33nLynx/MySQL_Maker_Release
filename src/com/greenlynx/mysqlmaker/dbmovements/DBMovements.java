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
	public static HBox hInsertFields;
	public static HBox hInsertExecution;
	public static HBox hInsertTable;
	public static HBox hInsertValues;
	public static Label lblInsertFieldsToFill;
	public static Label lblTableToInsert;
	public static Label lblValuesToInsert;
	public static Scene insertScene;
	public static Stage insertStage;
	public static TextField txtInsertFieldsToFill;
	public static TextField txtTableToInsert;
	public static TextField txtValuesToInsert;
	public static VBox vInsertBox;
	
	public static BorderPane SelectPanel;
	public static Button btnSelectExecution;
	public static HBox hSelectFields;
	public static HBox hSelectExecution;
	public static HBox hSelectTable;
	public static HBox hSelectValues;
	public static Label lblSelectFieldsToFill;
	public static Label lblTableToSelect;
	public static Label lblValuesToSelect;
	public static Scene SelectScene;
	public static Stage SelectStage;
	public static TextField txtSelectFieldsToFill;
	public static TextField txtTableToSelect;
	public static TextField txtValuesToSelect;
	public static VBox vSelectBox;
	
	public static BorderPane UpdatePanel;
	public static Button btnUpdateExecution;
	public static HBox hUpdateFields;
	public static HBox hUpdateExecution;
	public static HBox hUpdateTable;
	public static HBox hUpdateValues;
	public static Label lblUpdateFieldsToFill;
	public static Label lblTableToUpdate;
	public static Label lblValuesToUpdate;
	public static Scene UpdateScene;
	public static Stage UpdateStage;
	public static TextField txtUpdateFieldsToFill;
	public static TextField txtTableToUpdate;
	public static TextField txtValuesToUpdate;
	public static VBox vUpdateBox;
	
	public static BorderPane DeletePanel;
	public static Button btnDeleteExecution;
	public static HBox hDeleteFields;
	public static HBox hDeleteExecution;
	public static HBox hDeleteTable;
	public static HBox hDeleteValues;
	public static Label lblDeleteFieldsToFill;
	public static Label lblTableToDelete;
	public static Label lblValuesToDelete;
	public static Scene DeleteScene;
	public static Stage DeleteStage;
	public static TextField txtDeleteFieldsToFill;
	public static TextField txtTableToDelete;
	public static TextField txtValuesToDelete;
	public static VBox vDeleteBox;
	// ==========================
	
	public static void InsertQuery() {
		insertStage = new Stage();
		insertPanel = new BorderPane();
		insertScene = new Scene(insertPanel, 300, 150);
		
		vInsertBox = new VBox();
		
		hInsertTable = new HBox();
		lblTableToInsert = new Label("Table Name:");
		lblTableToInsert.setId("lblTableToInsert");
		txtTableToInsert = new TextField();
		hInsertTable.setAlignment(Pos.CENTER);
		hInsertTable.setSpacing(10);
		hInsertTable.getChildren().addAll(lblTableToInsert, txtTableToInsert);
		
		hInsertFields = new HBox();
		lblInsertFieldsToFill = new Label("Fields:");
		lblInsertFieldsToFill.setId("lblFieldsToFill");
		txtInsertFieldsToFill = new TextField();
		hInsertFields.setAlignment(Pos.CENTER);
		hInsertFields.setPadding(new Insets(0, 0, 0, 47));
		hInsertFields.setSpacing(10);
		hInsertFields.getChildren().addAll(lblInsertFieldsToFill, txtInsertFieldsToFill);
		
		hInsertValues = new HBox();
		lblValuesToInsert = new Label("Values:");
		lblValuesToInsert.setId("lblValuesToInsert");
		txtValuesToInsert = new TextField();
		hInsertFields.setAlignment(Pos.CENTER);
		hInsertFields.setPadding(new Insets(0, 0, 0, 41));
		hInsertFields.setSpacing(10);
		hInsertFields.getChildren().addAll(lblValuesToInsert, txtValuesToInsert);
		
		hInsertExecution = new HBox();
		btnInsertExecution = new Button("Execution!");
		btnInsertExecution.setOnMouseClicked(e -> InsertQueryAction());
		hInsertExecution.setAlignment(Pos.CENTER);
		hInsertExecution.setPadding(new Insets(20, 0, 0, 0));
		hInsertExecution.getChildren().addAll(btnInsertExecution);
		
		vInsertBox.setAlignment(Pos.CENTER);
		vInsertBox.getChildren().addAll(hInsertTable, hInsertFields, hInsertValues, hInsertExecution);
		
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
		SelectStage = new Stage();
		SelectPanel = new BorderPane();
		SelectScene = new Scene(SelectPanel, 300, 150);
		
		vSelectBox = new VBox();
		
		hSelectTable = new HBox();
		lblTableToSelect = new Label("Table Name:");
		lblTableToSelect.setId("lblTableToSelect");
		txtTableToSelect = new TextField();
		hSelectTable.setAlignment(Pos.CENTER);
		hSelectTable.setSpacing(10);
		hSelectTable.getChildren().addAll(lblTableToSelect, txtTableToSelect);
		
		hSelectFields = new HBox();
		lblSelectFieldsToFill = new Label("Fields:");
		lblSelectFieldsToFill.setId("lblFieldsToFill");
		txtSelectFieldsToFill = new TextField();
		hSelectFields.setAlignment(Pos.CENTER);
		hSelectFields.setPadding(new Insets(0, 0, 0, 47));
		hSelectFields.setSpacing(10);
		hSelectFields.getChildren().addAll(lblSelectFieldsToFill, txtSelectFieldsToFill);
		
		hSelectValues = new HBox();
		lblValuesToSelect = new Label("Values:");
		lblValuesToSelect.setId("lblValuesToSelect");
		txtValuesToSelect = new TextField();
		hSelectFields.setAlignment(Pos.CENTER);
		hSelectFields.setPadding(new Insets(0, 0, 0, 41));
		hSelectFields.setSpacing(10);
		hSelectFields.getChildren().addAll(lblValuesToSelect, txtValuesToSelect);
		
		hSelectExecution = new HBox();
		btnSelectExecution = new Button("Execution!");
		btnSelectExecution.setOnMouseClicked(e -> SelectQueryAction());
		hSelectExecution.setAlignment(Pos.CENTER);
		hSelectExecution.setPadding(new Insets(20, 0, 0, 0));
		hSelectExecution.getChildren().addAll(btnSelectExecution);
		
		vSelectBox.setAlignment(Pos.CENTER);
		vSelectBox.getChildren().addAll(hSelectTable, hSelectFields, hSelectValues, hSelectExecution);
		
		SelectPanel.setCenter(vSelectBox);
		
		SelectStage.setTitle("Select Query Window");
		SelectStage.setScene(SelectScene);
		SelectStage.setResizable(false);
		SelectStage.getIcons().add(new Image("file:res/DBMovements_Select.png"));
		SelectScene.getStylesheets().add("file:styles/DBMovements.css");
		SelectStage.show();
		Helper_Methods.CenterStage(SelectStage);
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
		UpdateStage = new Stage();
		UpdatePanel = new BorderPane();
		UpdateScene = new Scene(UpdatePanel, 300, 150);
		
		vUpdateBox = new VBox();
		
		hUpdateTable = new HBox();
		lblTableToUpdate = new Label("Table Name:");
		lblTableToUpdate.setId("lblTableToUpdate");
		txtTableToUpdate = new TextField();
		hUpdateTable.setAlignment(Pos.CENTER);
		hUpdateTable.setSpacing(10);
		hUpdateTable.getChildren().addAll(lblTableToUpdate, txtTableToUpdate);
		
		hUpdateFields = new HBox();
		lblUpdateFieldsToFill = new Label("Fields:");
		lblUpdateFieldsToFill.setId("lblFieldsToFill");
		txtUpdateFieldsToFill = new TextField();
		hUpdateFields.setAlignment(Pos.CENTER);
		hUpdateFields.setPadding(new Insets(0, 0, 0, 47));
		hUpdateFields.setSpacing(10);
		hUpdateFields.getChildren().addAll(lblUpdateFieldsToFill, txtUpdateFieldsToFill);
		
		hUpdateValues = new HBox();
		lblValuesToUpdate = new Label("Values:");
		lblValuesToUpdate.setId("lblValuesToUpdate");
		txtValuesToUpdate = new TextField();
		hUpdateFields.setAlignment(Pos.CENTER);
		hUpdateFields.setPadding(new Insets(0, 0, 0, 41));
		hUpdateFields.setSpacing(10);
		hUpdateFields.getChildren().addAll(lblValuesToUpdate, txtValuesToUpdate);
		
		hUpdateExecution = new HBox();
		btnUpdateExecution = new Button("Execution!");
		btnUpdateExecution.setOnMouseClicked(e -> UpdateQueryAction());
		hUpdateExecution.setAlignment(Pos.CENTER);
		hUpdateExecution.setPadding(new Insets(20, 0, 0, 0));
		hUpdateExecution.getChildren().addAll(btnUpdateExecution);
		
		vUpdateBox.setAlignment(Pos.CENTER);
		vUpdateBox.getChildren().addAll(hUpdateTable, hUpdateFields, hUpdateValues, hUpdateExecution);
		
		UpdatePanel.setCenter(vUpdateBox);
		
		UpdateStage.setTitle("Update Query Window");
		UpdateStage.setScene(UpdateScene);
		UpdateStage.setResizable(false);
		UpdateStage.getIcons().add(new Image("file:res/DBMovements_Update.png"));
		UpdateScene.getStylesheets().add("file:styles/DBMovements.css");
		UpdateStage.show();
		Helper_Methods.CenterStage(UpdateStage);
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
		DeleteStage = new Stage();
		DeleteStage = new Stage();
		DeletePanel = new BorderPane();
		DeleteScene = new Scene(DeletePanel, 300, 150);
		
		vDeleteBox = new VBox();
		
		hDeleteTable = new HBox();
		lblTableToDelete = new Label("Table Name:");
		lblTableToDelete.setId("lblTableToDelete");
		txtTableToDelete = new TextField();
		hDeleteTable.setAlignment(Pos.CENTER);
		hDeleteTable.setSpacing(10);
		hDeleteTable.getChildren().addAll(lblTableToDelete, txtTableToDelete);
		
		hDeleteFields = new HBox();
		lblDeleteFieldsToFill = new Label("Fields:");
		lblDeleteFieldsToFill.setId("lblFieldsToFill");
		txtDeleteFieldsToFill = new TextField();
		hDeleteFields.setAlignment(Pos.CENTER);
		hDeleteFields.setPadding(new Insets(0, 0, 0, 47));
		hDeleteFields.setSpacing(10);
		hDeleteFields.getChildren().addAll(lblDeleteFieldsToFill, txtDeleteFieldsToFill);
		
		hDeleteValues = new HBox();
		lblValuesToDelete = new Label("Values:");
		lblValuesToDelete.setId("lblValuesToDelete");
		txtValuesToDelete = new TextField();
		hDeleteFields.setAlignment(Pos.CENTER);
		hDeleteFields.setPadding(new Insets(0, 0, 0, 41));
		hDeleteFields.setSpacing(10);
		hDeleteFields.getChildren().addAll(lblValuesToDelete, txtValuesToDelete);
		
		hDeleteExecution = new HBox();
		btnDeleteExecution = new Button("Execution!");
		btnDeleteExecution.setOnMouseClicked(e -> DeleteQueryAction());
		hDeleteExecution.setAlignment(Pos.CENTER);
		hDeleteExecution.setPadding(new Insets(20, 0, 0, 0));
		hDeleteExecution.getChildren().addAll(btnDeleteExecution);
		
		vDeleteBox.setAlignment(Pos.CENTER);
		vDeleteBox.getChildren().addAll(hDeleteTable, hDeleteFields, hDeleteValues, hDeleteExecution);
		
		DeletePanel.setCenter(vDeleteBox);
		
		DeleteStage.setTitle("Delete Query Window");
		DeleteStage.setScene(DeleteScene);
		DeleteStage.setResizable(false);
		DeleteStage.getIcons().add(new Image("file:res/DBMovements_Delete.png"));
		DeleteScene.getStylesheets().add("file:styles/DBMovements.css");
		DeleteStage.show();
		Helper_Methods.CenterStage(DeleteStage);
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

}