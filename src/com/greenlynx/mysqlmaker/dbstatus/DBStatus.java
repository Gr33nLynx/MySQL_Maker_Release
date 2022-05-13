package com.greenlynx.mysqlmaker.dbstatus;

// ============= Imports =============
import com.greenlynx.mysqlmaker.dbcreds.DBCreds;
import com.greenlynx.mysqlmaker.helpers.Helper_Methods;
import com.greenlynx.mysqlmaker.mainwindow.MainWindow;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.image.Image;
// ===================================

/**
 * <b>PROJECT NAME:</b><br> 
 * &nbsp;&nbsp;&nbsp;&nbsp;MySQL Maker<br>
 * <b>PROJECT DESCRIPTION:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;GUI for the creation of MySQL code in an automated way<br>
 * <b>FILE NAME:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;DBStatus.java<br>
 * <b>FILE DESCRIPTION:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;DB Connections Matters Class<br>
 * <b>NOTES:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;All plagiarism attempts // Code theft will be reported by the 
 * &nbsp;&nbsp;&nbsp;&nbsp;author<br>
 * <b>COPYRIGHT:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;©2022 GR33NLYNX
 * @author GR33NLYNX
 * @version 1.0
 */
public class DBStatus {

	// ======= Attributes =======
	public static Connection DBLink;
	public static String DBName;
	public static String DBPassword;
	public static String DBUser;
	// ==========================
	
	/**
	 * MySQL80 Service Checker
	 */
	public static void MySQLStatus() {
		ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "sc query MySQL80 | findstr RUNNING");
		Process p = null;

		try {
			p = pb.start();
			BufferedReader pReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = pReader.readLine()) != null) {
				sb.append(line);
			}
			String result = sb.toString().trim();
			if (result.contains("RUNNING")) {
				DBCreds.DBCredentials();
			}
			else {
				Helper_Methods.ErrorStage(350,
										  150,
										  "MySQL Service Error!",
						  				  "Impossible to reach MySQL80 Service",
						  				  "Possible Solutions:\n" +
						  				  "1 - Enable MySQL80 Service",
						  				  new Image("file:res/ErrorWindow_UnreachableService.png"));
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Connect to an specific DB
	 */
	public static void DBConnection() {
		if (DBCreds.txtUser.getText().isEmpty() ||
				DBCreds.txtPassword.getText().isEmpty() ||
					DBCreds.txtDB.getText().isEmpty()) {
			Helper_Methods.ErrorStage(350,
									  100,
									  "Fields Error!", 
									  "One of the fields has been detected empty",
									  "Possible Solutions:\n" +
									  "- Fill all fields to make a connection",
									  new Image("file:res/ErrorWindow_DBError.png"));
			DBCreds.txtUser.setText("");
			DBCreds.txtPassword.setText("");
			DBCreds.txtDB.setText("");
			DBCreds.txtUser.requestFocus();
		}
		else {
			try {
				DBName = DBCreds.txtDB.getText();
				DBUser = DBCreds.txtUser.getText();
				DBPassword = DBCreds.txtPassword.getText();
				
				DBLink = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DBName, DBUser, DBPassword);
				
				MainWindow.mysqlConnect.setDisable(true);
				MainWindow.mysqlDisconnect.setDisable(false);
				
				DBCreds.txtUser.setText("");
				DBCreds.txtPassword.setText("");
				DBCreds.txtDB.setText("");
				
				DBCreds.DBStage.close();

				MainWindow.lblStatusText.setText("ON");
				MainWindow.lblStatusText.setStyle("-fx-text-fill: green;");
				
				MainWindow.toolsInsert.setDisable(false);
				MainWindow.toolsSelect.setDisable(false);
				MainWindow.toolsUpdate.setDisable(false);
				MainWindow.toolsDelete.setDisable(false);
				
				MainWindow.taResult.setVisible(true);
				MainWindow.taResult.setText("Query Results Here:\n\n");
				
				//MainWindow.toolsProcedure.setDisable(false);
				//MainWindow.toolsFunction.setDisable(false);
				//MainWindow.toolsTrigger.setDisable(false);
			} 
			catch (SQLException e) {
				Helper_Methods.ErrorStage(400,
										  150,
										  "Connection Error!", 
										  "Impossible to connect to the " + DBCreds.txtDB.getText() + " DB",
										  "Possible Problems:\n" +
									      "1 - Your credentials are incorrect\n" +
										  "2 - You don't have permission to connect to the DB",
										  new Image("file:res/ErrorWindow_DBError.png"));
				DBCreds.txtUser.setText("");
				DBCreds.txtPassword.setText("");
				DBCreds.txtDB.setText("");
				DBCreds.txtUser.requestFocus();
			}
		}
	}
	
	public static void DBDisconnection() {
		try {
			DBLink.close();
			MainWindow.mysqlConnect.setDisable(false);
			MainWindow.mysqlDisconnect.setDisable(true);
			
			MainWindow.lblStatusText.setText("OFF");
			MainWindow.lblStatusText.setStyle("-fx-text-fill: red;");
			
			MainWindow.toolsInsert.setDisable(true);
			MainWindow.toolsSelect.setDisable(true);
			MainWindow.toolsUpdate.setDisable(true);
			MainWindow.toolsDelete.setDisable(true);
			
			MainWindow.taResult.setVisible(false);
			MainWindow.taResult.setText("");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}