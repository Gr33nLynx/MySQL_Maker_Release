package com.greenlynx.mysqlmaker.eula;

// ============= Imports =============
import com.greenlynx.mysqlmaker.helpers.Helper_Methods;
import com.greenlynx.mysqlmaker.mainwindow.MainWindow;
import com.greenlynx.mysqlmaker.trial.Trial;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
// ===================================

/**
 * <b>PROJECT NAME:</b><br> 
 * &nbsp;&nbsp;&nbsp;&nbsp;MySQL Maker<br>
 * <b>PROJECT DESCRIPTION:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;GUI for the creation of MySQL code in an automated way<br>
 * <b>FILE NAME:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;Eula.java<br>
 * <b>FILE DESCRIPTION:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;Application's EULA Class<br>
 * <b>NOTES:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;All plagiarism attempts // Code theft will be reported by the 
 * &nbsp;&nbsp;&nbsp;&nbsp;author<br>
 * <b>COPYRIGHT:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;©2022 GR33NLYNX
 * @author GR33NLYNX
 * @version 1.0
 */
public class Eula extends Application {
	
	// ======= Attributes =======
	public static BorderPane EULAWindow;
	public static BorderPane EulaPanel;
	public static Button btnAccept;
	public static Button btnDecline;
	public static HBox hButtons;
	public static Scene EulaScene;
	public static Stage EulaStage;
	public static StringBuilder sb;
	public static VBox vEulaInfo;
	public static WebView wvEulaInfo;
	public static final File f = new File(System.getenv("USERPROFILE") + getEncodedPath());
	// ==========================
	
	/**
	 * Application's EULA
	 * @throws Exception
	 */
	@Override
	public void start(Stage arg0) throws Exception {
		// If EULA is not accepted yet
		if (!isAccepted()) {
			// Creating...
			EulaStage = new Stage();
			EulaPanel = EULAConfig();
			EulaScene = new Scene(EulaPanel, 860, 700);
			
			// Configuring
			EulaStage.setTitle("MySQL Maker's EULA");
			EulaStage.setScene(EulaScene);
			
			EulaStage.setResizable(false);
			EulaStage.getIcons().add(new Image("file:res/EULA_Icon.jpg"));
			EulaScene.getStylesheets().add("file:styles/EULAWindow_Styles.css");
			
			// Showing && Centering...
			EulaStage.show();
			Helper_Methods.CenterStage(EulaStage);
			
			// If EULA is closed
			EulaStage.setOnCloseRequest(e -> Platform.exit());
		}
		// If EULA is accepted
		else {
			MainWindow.MainWindowLoader();
		}
	}
	
	/**
	 * Check if the EULA is accepted
	 * @return true || false
	 */
	public static boolean isAccepted() {
		// Configuring...
		if (f.exists()) {
			try {
				try(BufferedReader reader = new BufferedReader(new FileReader(f))) {
					String line;
					while ((line = reader.readLine()) != null) {
						if (line.equals("YES")) {
							reader.close();
							
							// Returning...
							return true;
						}
					}
				}
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// Returning...
		return false;
	}
	
	/**
	 * EULA's Configurator
	 * @return EULAWindow
	 */
	public BorderPane EULAConfig() {
		// Creating...
		EULAWindow = new BorderPane();
		
		// Configuring...
		EULAWindow.setCenter(EULACenterSite());
		EULAWindow.setBottom(EULABottomSite());
		
		// Returning...
		return EULAWindow;
	}
	
	/**
	 * EULA's Bottom Site
	 * @return sEulaInfo
	 */
	public VBox EULACenterSite() {
		// Creating...
		vEulaInfo = new VBox();
		
		// Configuring...
		vEulaInfo.setId("vEulaInfo");
		vEulaInfo.getChildren().add(EULAContent());
		
		// Returning...
		return vEulaInfo;
	}
	
	/**
	 * EULA's Content
	 * @return
	 */
	public WebView EULAContent() {
		// Creating...
		wvEulaInfo = new WebView();
		
		// Configuring...
		wvEulaInfo.setPrefHeight(800);
		wvEulaInfo.getEngine().loadContent
		(""
				+ "<h2>End-User License Agreement (EULA) of <span class=\"app_name\">MySQL Maker</span></h2>\r\n"
				+ "\r\n"
				+ "<p>This End-User License Agreement (\"EULA\") is a legal agreement between you and <span class=\"company_name\">Gr33nLynx</span>.</p>\r\n"
				+ "\r\n"
				+ "<p>This EULA agreement governs your acquisition and use of the <span class=\"app_name\">MySQL Maker</span> software (\"Software\") directly from <span class=\"company_name\">Gr33nLynx</span>.</p>\r\n"
				+ "\r\n"
				+ "<p>Please read this EULA agreement carefully before completing the installation process and using the <span class=\"app_name\">MySQL Maker</span> software.<br> It provides a license to use the <span class=\"app_name\">MySQL Maker</span> software and contains warranty information and liability disclaimers.</p>\r\n"
				+ "\r\n"
				+ "<p>If you register for a free trial of the <span class=\"app_name\">MySQL Maker</span> software, this EULA agreement will also govern that trial. By clicking \"accept\" or installing and/or using the <span class=\"app_name\">MySQL Maker</span> software, you are confirming your acceptance of the Software and agreeing to become bound by the terms of this EULA agreement.</p>\r\n"
				+ "\r\n"
				+ "<p>If you are entering into this EULA agreement on behalf of a company or other legal entity, you represent that you have the authority to bind such entity and its affiliates to these terms and conditions. If you do not have such authority or if you do not agree with the terms and conditions of this EULA agreement, do not install or use the Software, and you must not accept this EULA agreement.</p>\r\n"
				+ "\r\n"
				+ "<p>This EULA agreement shall apply only to the Software supplied by <span class=\"company_name\">Gr33nLynx</span> herewith regardless of whether other software is referred to or described herein. The terms also apply to any <span class=\"company_name\">Gr33nLynx</span> updates, supplements, Internet-based services, and support services for the Software, unless other terms accompany those items on delivery. If so, those terms apply.</p>\r\n"
				+ "\r\n"
				+ "<h3>License Grant</h3>\r\n"
				+ "\r\n"
				+ "<p><span class=\"company_name\">Gr33nLynx</span> hereby grants you a personal, non-transferable, non-exclusive licence to use the <span class=\"app_name\">MySQL Maker</span> software on your devices in accordance with the terms of this EULA agreement.</p>\r\n"
				+ "\r\n"
				+ "<p>You are permitted to load the <span class=\"app_name\">MySQL Maker</span> software (for example a PC, laptop, mobile or tablet) under your control.<br> You are responsible for ensuring your device meets the minimum requirements of the <span class=\"app_name\">MySQL Maker</span> software.</p>\r\n"
				+ "\r\n"
				+ "<p>You are not permitted to:</p>\r\n"
				+ "\r\n"
				+ "<ul>\r\n"
				+ "<li>Edit, alter, modify, adapt, translate or otherwise change the whole or any part of the Software nor permit the whole or any part of the Software to be combined with or become incorporated in any other software, nor decompile, disassemble or reverse engineer the Software or attempt to do any such things</li>\r\n"
				+ "<li>Reproduce, copy, distribute, resell or otherwise use the Software for any commercial purpose</li>\r\n"
				+ "<li>Allow any third party to use the Software on behalf of or for the benefit of any third party</li>\r\n"
				+ "<li>Use the Software in any way which breaches any applicable local, national or international law</li>\r\n"
				+ "<li>Use the Software for any purpose that <span class=\"company_name\">Gr33nLynx</span> considers is a breach of this EULA agreement</li>\r\n"
				+ "</ul>\r\n"
				+ "\r\n"
				+ "<h3>Intellectual Property and Ownership</h3>\r\n"
				+ "\r\n"
				+ "<p><span class=\"company_name\">Gr33nLynx</span> shall at all times retain ownership of the Software as originally downloaded by you and all subsequent downloads of the Software by you. The Software (and the copyright, and other intellectual property rights of whatever nature in the Software, including any modifications made thereto) are and shall remain the property of <span class=\"company_name\">Gr33nLynx</span>.</p>\r\n"
				+ "\r\n"
				+ "<p><span class=\"company_name\">Gr33nLynx</span> reserves the right to grant licences to use the Software to third parties.</p>\r\n"
				+ "\r\n"
				+ "<h3>Termination</h3>\r\n"
				+ "\r\n"
				+ "<p>This EULA agreement is effective from the date you first use the Software and shall continue until terminated. You may terminate it at any time upon written notice to <span class=\"company_name\">Gr33nLynx</span>.</p>\r\n"
				+ "\r\n"
				+ "<p>It will also terminate immediately if you fail to comply with any term of this EULA agreement. Upon such termination, the licenses granted by this EULA agreement will immediately terminate and you agree to stop all access and use of the Software. The provisions that by their nature continue and survive will survive any termination of this EULA agreement.</p>\r\n"
				+ "\r\n"
				+ "<h3>Governing Law</h3>\r\n"
				+ "\r\n"
				+ "<p>This EULA agreement, and any dispute arising out of or in connection with this EULA agreement, shall be governed by and construed in accordance with the applicable legislation.</p>"
				+ 
		"");
		
		// Returning...
		return wvEulaInfo;
	}
	
	/**
	 * EULA's Bottom Site
	 * @return hButtons
	 */
	public HBox EULABottomSite() {
		// Creating...
		hButtons = new HBox();
		btnAccept = new Button("Accept");
		btnDecline = new Button("Decline");
		
		// Configuring...
		btnAccept.setPrefSize(100, 10);
		btnAccept.setOnAction(e -> CreateEulaConfigFile());
		btnDecline.setPrefSize(100, 10);
		btnDecline.setOnAction(e -> Platform.exit());
		hButtons.setAlignment(Pos.CENTER);
		hButtons.setPadding(new Insets(0,0,10,0));
		hButtons.setSpacing(10);
		hButtons.getChildren().addAll(btnAccept, btnDecline);
		
		// Returning...
		return hButtons;
	}
	
	/**
	 * Create Eula Configuration Files 
	 */
	public static void CreateEulaConfigFile() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
			writer.write("YES");
			writer.close();
			
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
		finally {
			EulaStage.close();
			Trial.TrialStarter();
		}
	}
	
	/**
	 * Return EULA File's Path (Encoded)
	 * @return decodedPath
	 */
	public static String getEncodedPath() {
		// Configuring...
		String encodedPath = "XFxBcHBEYXRhXFxMb2NhbExvd1xcVGVtcFxcZDRLY3g0TjJxMlpGdTVLTnVuZVpUWUJHZnRYVVVXLnRtcA==";
		String decodedPath = "";
		
		byte[] encodedPathBytes = encodedPath.getBytes();
		
		byte[] decodedPathBytes = Base64.getDecoder().decode(encodedPathBytes);
		decodedPath = new String(decodedPathBytes);
		
		// Returning...
		return decodedPath;
	}
}