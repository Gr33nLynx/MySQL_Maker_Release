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
import javafx.scene.text.TextAlignment;
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
	public static BufferedReader reader;
	public static BufferedWriter writer;
	public static Label lblTrialDescription;
	public static Label lblTrialEmail;
	public static Label lblTrialTitle;
	public static Scene TrialFinishedScene;
	public static Scene TrialScene;
	public static Stage TrialFinishedStage;
	public static Stage TrialStage;
	public static VBox vTrialDescription;
	public static VBox vTrialEmail;
	public static VBox vTrialInfo;
	public static VBox vTrialTitle;
	public static final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
	public static final File f = new File(System.getenv("USERPROFILE") + getEncodedPath());
	// ==========================
	
	/**
	 * Load Trial (FIRST STEP)
	 */
	public static void TrialStarter() {
		TrialStage = new Stage();
		TrialPanel = TrialConfig();
		TrialScene = new Scene(TrialPanel, 350, 300);
		
		TrialStage.setTitle("MySQL Maker's 30 Days Trial");
		TrialStage.setScene(TrialScene);
		
		TrialStage.setResizable(false);
		TrialStage.getIcons().add(new Image("file:res/TrialWindow_Icon.png"));
		TrialScene.getStylesheets().add("file:styles/TrialWindow.css");
		
		TrialStage.show();
		Helper_Methods.CenterStage(TrialStage);
		
		CreateTrialConfigFile();
		
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
		TrialPanel = new BorderPane();
		
		TrialPanel.setCenter(TrialCenterSite());
		
		return TrialPanel;
	}
	
	/**
	 * Trial's Center Site
	 * @return TrialPanel
	 */
	public static VBox TrialCenterSite() {
		vTrialInfo = new VBox();
		
		vTrialDescription = new VBox();
		lblTrialDescription = new Label
		(
				"Welcome to MySQLMaker!\r\n\n"
				+ "I, GreenLynx, thank you for using my software.\r\n"
				+ "Your 30-day trial period begins here.\r\n"
				+ "I must tell you that this program is fail-safe\n and any sabotage attempts are controlled.\r\n"
				+ "\r\n"
				+ "If you require the PRO version, \nplease contact me in the next e-mail address:\n"
				+ "");
		lblTrialDescription.setId("lblTrialDescription");
		lblTrialDescription.setTextAlignment(TextAlignment.CENTER);
		
		vTrialEmail = new VBox();
		lblTrialEmail = new Label("\ngreenlynxonfire@gmail.com");
		lblTrialEmail.setId("lblTrialEmail");
		lblTrialEmail.setTextAlignment(TextAlignment.CENTER);
		
		vTrialDescription.setAlignment(Pos.TOP_CENTER);
		vTrialDescription.getChildren().add(lblTrialDescription);
		
		vTrialEmail.setAlignment(Pos.TOP_CENTER);
		vTrialEmail.getChildren().add(lblTrialEmail);
		
		vTrialInfo.setAlignment(Pos.CENTER);
		vTrialInfo.setPadding(new Insets(10,0,0,0));
		vTrialInfo.getChildren().addAll(vTrialDescription, vTrialEmail);
		
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
		TrialFinishedStage = new Stage();
		TrialFinishedPanel = new BorderPane();
		TrialFinishedScene = new Scene(TrialFinishedPanel, 500, 400);
	
		TrialFinishedStage.setTitle("MySQL Maker's 30 Trial has finished!");
		TrialFinishedStage.setScene(TrialFinishedScene);
		
		TrialFinishedStage.setResizable(false);
		//TrialFinishedStage.getIcons().add(new Image("file:res/EULA_Icon.jpg"));
		//TrialFinishedScene.getStylesheets().add("file:styles/EULAWindow_Styles.css");
		
		TrialFinishedStage.show();
		Helper_Methods.CenterStage(TrialFinishedStage);
		
		TrialFinishedStage.setOnCloseRequest(e -> Platform.exit());
	}
	
	
	/**
	 * Set Trial Configuration File's Dates
	 */
	public static void SetDates() {
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
		return false;
	}
	
	/**
	 * Check if the user has modified the system's clock
	 * @return true || false
	 */
	public static boolean SystemTimeModify() {
		try {
			reader = new BufferedReader(new FileReader(f));
			String now = LocalDateTime.now().format(formatter);
			String start = reader.readLine();
			
			return now.compareTo(start) < 0;
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Check if the Trial's config file has been modified
	 * @return true || false
	 * @throws IOException 
	 */
	public static boolean ConfigFileModify() throws IOException {
		return ModifyDateGetter().compareTo(CreationDateGetter()) == 1;
	}
	
	/**
	 * Get file's creation time
	 * @return
	 * @throws IOException 
	 */
	public static String CreationDateGetter() throws IOException {
		BasicFileAttributes attributes = Files.readAttributes(f.toPath(), BasicFileAttributes.class);
		
		return new String(attributes.creationTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().format(formatter));
	}
	
	/**
	 * Get file's modification time
	 * @return
	 * @throws IOException 
	 */
	public static String ModifyDateGetter() throws IOException {
		BasicFileAttributes attributes = Files.readAttributes(f.toPath(), BasicFileAttributes.class);
		
		return new String(attributes.lastModifiedTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().format(formatter));
	}
	
	/**
	 * Return Trial File's Configuration's Path (Encoded)
	 * @return decodedPath
	 */
	public static String getEncodedPath() {
		String encodedPath = "XFxBcHBEYXRhXFxMb2NhbExvd1xcVGVtcFxcemV3bHloYzJ2c2o4cHptdHludnhmdnpyeWlxaml5LnRtcA==";
		String decodedPath = "";
		
		byte[] encodedPathBytes = encodedPath.getBytes();
		
		byte[] decodedPathBytes = Base64.getDecoder().decode(encodedPathBytes);
		decodedPath = new String(decodedPathBytes);
		
		return decodedPath;
	}
	
}