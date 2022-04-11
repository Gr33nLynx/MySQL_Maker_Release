package com.greenlynx.mysqlmaker.trial;

//============= Imports =============
import com.greenlynx.mysqlmaker.helpers.Helper_Methods;
import com.greenlynx.mysqlmaker.mainwindow.MainWindow;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//===================================

/**
* <b>PROJECT NAME:</b><br> 
* &nbsp;&nbsp;&nbsp;&nbsp;MySQL Maker<br>
* <b>PROJECT DESCRIPTION:</b><br>
* &nbsp;&nbsp;&nbsp;&nbsp;GUI for the creation of MySQL code in an automated way<br>
* <b>FILE NAME:</b><br>
* &nbsp;&nbsp;&nbsp;&nbsp;Trial.java<br>
* <b>FILE DESCRIPTION:</b><br>
* &nbsp;&nbsp;&nbsp;&nbsp;Application's Trial Class<br>
* <b>NOTES:</b><br>
* &nbsp;&nbsp;&nbsp;&nbsp;All plagiarism attempts // Code theft will be reported by the 
* &nbsp;&nbsp;&nbsp;&nbsp;author<br>
* <b>COPYRIGHT:</b><br>
* &nbsp;&nbsp;&nbsp;&nbsp;©2022 GR33NLYNX
* @author GR33NLYNX
* @version 1.0
*/
public class Trial{
	
	// ======= Attributes =======
	public static BorderPane TrialFinishedPanel;
	public static BorderPane TrialFinishedWindow;
	public static BorderPane TrialPanel;
	public static BorderPane TrialWindow;
	public static Label lblTrialTitle;
	public static Label lblTrialDescription;
	public static VBox vTrialInfo;
	public static BufferedReader reader;
	public static BufferedWriter writer;
	public static Scene TrialFinishedScene;
	public static Scene TrialScene;
	public static Stage TrialFinishedStage;
	public static Stage TrialStage;
	public static final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
	public static final File f = new File(System.getenv("USERPROFILE") + getEncodedPath());
	// ==========================
	
	/**
	 * Load Trial (FIRST STEP)
	 */
	public static void TrialStarter() {
		// Creating...
		TrialStage = new Stage();
		TrialPanel = TrialConfig();
		TrialScene = new Scene(TrialPanel, 500, 400);
		
		// Configuring
		TrialStage.setTitle("MySQL Maker's 30 Days Trial");
		TrialStage.setScene(TrialScene);
		
		TrialStage.setResizable(false);
		TrialStage.getIcons().add(new Image("file:res/TrialWindow_Icon.png"));
		TrialScene.getStylesheets().add("file:styles/TrialWindow_Styles.css");
		
		
		
		// Showing && Centering...
		TrialStage.show();
		Helper_Methods.CenterStage(TrialStage);
		
		CreateTrialConfigFile();
		
		// If Trial is closed
		TrialStage.setOnCloseRequest(e -> {
			try {
				MainWindow.MainWindowLoader();
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
		});
	}
	
	/**
	 * Trial's Configurator
	 * @return TrialPanel
	 */
	public static BorderPane TrialConfig() {
		// Creating...
		TrialPanel = new BorderPane();
		
		// Configuring...
		TrialPanel.setCenter(TrialCenterSite());
		
		// Returning...
		return TrialPanel;
	}
	
	/**
	 * Trial's Center Site
	 * @return TrialPanel
	 */
	public static VBox TrialCenterSite() {
		// Creating...
		vTrialInfo = new VBox();
		lblTrialTitle = new Label("MySQL Maker's Trial");
		lblTrialDescription = new Label("");
		
		// Configuring...
		lblTrialTitle.setId("lblTrialTitle");
		vTrialInfo.setAlignment(Pos.TOP_CENTER);
		vTrialInfo.setPadding(new Insets(20, 0, 0, 0));
		vTrialInfo.getChildren().add(lblTrialTitle);
		
		// Returning...
		return vTrialInfo;
	}
	
	/**
	 * Create Trial Configuration Files
	 */
	public static void CreateTrialConfigFile() {
		try {
			writer = new BufferedWriter(new FileWriter(f, true));
			String now = LocalDateTime.now().format(formatter);
			String end = LocalDateTime.now().plusDays(30).format(formatter);
			writer.write(now);
			writer.write("\n");
			writer.write(end);
			writer.close();
			
			SetDates();
			
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "attrib +h", System.getenv("USERPROFILE") + getEncodedPath());
			try {
				pb.start();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * End Trial (LAST STEP)
	 */
	public static void TrialFinisher() {
		// Creating...
		TrialFinishedStage = new Stage();
		TrialFinishedPanel = new BorderPane();
		TrialFinishedScene = new Scene(TrialFinishedPanel, 500, 400);
				
		// Configuring
		TrialFinishedStage.setTitle("MySQL Maker's 30 Trial has finished!");
		TrialFinishedStage.setScene(TrialFinishedScene);
		
		TrialFinishedStage.setResizable(false);
		//TrialFinishedStage.getIcons().add(new Image("file:res/EULA_Icon.jpg"));
		//TrialFinishedScene.getStylesheets().add("file:styles/EULAWindow_Styles.css");
		
		// Showing && Centering...
		TrialFinishedStage.show();
		Helper_Methods.CenterStage(TrialFinishedStage);
		
		// If Trial is closed
		TrialFinishedStage.setOnCloseRequest(e -> Platform.exit());
	}
	
	
	/**
	 * Set Trial Configuration File's Dates
	 */
	public static void SetDates() {
		// Configuring...
		try {
			Path fPath = f.toPath();
			long now = System.currentTimeMillis();
			FileTime ft = FileTime.fromMillis(now);
			Files.setAttribute(fPath, "creationTime", ft, LinkOption.NOFOLLOW_LINKS);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Check Trial Status
	 * @return true || false
	 */
	public static boolean TrialChecker() {
		// Configuring...
		try {
			if (f.exists()) {
				reader = new BufferedReader(new FileReader(f));
				
				String end = "";
				int lineNumber = 1;
				while (lineNumber <= 2) {
					end = reader.readLine();
					lineNumber++;
				}
				
				String now = LocalDateTime.now().format(formatter);
				if (now.compareTo(end) >= 0) {
					Trial.TrialFinisher();
					
					// Returning...
					return true;
				}
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		// Returning...
		return false;
	}
	
	/**
	 * Check if the user has modified the system's clock
	 * @return true || false
	 */
	public static boolean SystemTimeModify() {
		// Configuring...
		try {
			reader = new BufferedReader(new FileReader(f));
			String now = LocalDateTime.now().format(formatter);
			String start = reader.readLine();
			
			// Returning...
			return now.compareTo(start) < 0;
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		// Returning...
		return false;
	}
	
	/**
	 * Check if the Trial's config file has been modified
	 * @return true || false
	 * @throws IOException 
	 */
	public static boolean ConfigFileModify() throws IOException {
		// Returning...
		return ModifyDateGetter().compareTo(CreationDateGetter()) == 1;
	}
	
	/**
	 * Get file's creation time
	 * @return
	 * @throws IOException 
	 */
	public static String CreationDateGetter() throws IOException {
		// Creating...
		BasicFileAttributes attributes = Files.readAttributes(f.toPath(), BasicFileAttributes.class);
		
		// Returning...
		return new String(attributes.creationTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().format(formatter));
	}
	
	/**
	 * Get file's modification time
	 * @return
	 * @throws IOException 
	 */
	public static String ModifyDateGetter() throws IOException {
		// Creating...
		BasicFileAttributes attributes = Files.readAttributes(f.toPath(), BasicFileAttributes.class);
		
		// Returning...
		return new String(attributes.lastModifiedTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().format(formatter));
	}
	
	/**
	 * Return Trial File's Configuration's Path (Encoded)
	 * @return decodedPath
	 */
	public static String getEncodedPath() {
		// Configuring...
		String encodedPath = "XFxBcHBEYXRhXFxMb2NhbExvd1xcVGVtcFxcemV3bHloYzJ2c2o4cHptdHludnhmdnpyeWlxaml5LnRtcA==";
		String decodedPath = "";
		
		byte[] encodedPathBytes = encodedPath.getBytes();
		
		byte[] decodedPathBytes = Base64.getDecoder().decode(encodedPathBytes);
		decodedPath = new String(decodedPathBytes);
		
		// Returning...
		return decodedPath;
	}
	
}