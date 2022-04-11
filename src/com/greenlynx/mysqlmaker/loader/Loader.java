package com.greenlynx.mysqlmaker.loader;

//============= Imports =============
import com.greenlynx.mysqlmaker.eula.Eula;
import javafx.application.Application;
// ===================================

/**
 * <b>PROJECT NAME:</b><br> 
 * &nbsp;&nbsp;&nbsp;&nbsp;MySQL Maker<br>
 * <b>PROJECT DESCRIPTION:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;GUI for the creation of MySQL code in an automated way<br>
 * <b>FILE NAME:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;Loader.java<br>
 * <b>FILE DESCRIPTION:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;Application's Loader Class<br>
 * <b>NOTES:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;All plagiarism attempts // Code theft will be reported by the 
 * &nbsp;&nbsp;&nbsp;&nbsp;author<br>
 * <b>COPYRIGHT:</b><br>
 * &nbsp;&nbsp;&nbsp;&nbsp;©2022 GR33NLYNX
 * @author GR33NLYNX
 * @version 1.0
 */

public class Loader {
	public static void main(String[] args) {
		// Run the application by a Runnable
		new Runnable() {
			public void run() {
				Application.launch(Eula.class);
			}
		}.run();
	}
}
