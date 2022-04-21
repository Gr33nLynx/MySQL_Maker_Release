/**
 * PROJECT NAME: 
 * 		MySQL Maker
 * PROJECT DESCRIPTION:
 * 		GUI for the creation of MySQL code in an automated way
 * FILE NAME:
 * 		MainWindow.java
 * FILE DESCRIPTION:
 * 		Application's Main Window's Class
 * NOTES:
 * 		All plagiarism attempts // Code theft will be reported by the 
 * COPYRIGHT:
 * AUTHOR:
 * 		©2022 GR33NLYNX
 */

				-- DATABASE --
/* ------------------------------------- */
	DROP DATABASE IF EXISTS `MySQLMaker`;
	CREATE DATABASE `MySQLMaker`;
	USE `MySQLMaker`;
/* ------------------------------------- */

										-- INSERT STORED PROCEDURE --
/* ------------------------------------------------------------------------------------------------------ */
	DROP PROCEDURE IF EXISTS sp_Insert;
	DELIMITER $$
	CREATE PROCEDURE sp_Insert (TableToInsert VARCHAR(50), FieldsToFill LONGTEXT, ValuesToInsert LONGTEXT)
	BEGIN
		INSERT INTO `TableToInsert` (`FieldsToFill`) VALUES (`ValuesToInsert`); 
	END
	$$
	DELIMITER ;
/* ------------------------------------------------------------------------------------------------------ */    

										-- SELECT STORED PROCEDURE --
/* -------------------------------------------------------------------------------------------------------- */
	DROP PROCEDURE IF EXISTS sp_Select;
	DELIMITER $$
	CREATE PROCEDURE sp_Select (DataToRecover VARCHAR(50), TableToRecover VARCHAR(50), ConditionToApply LONGTEXT)
	BEGIN
		SELECT `DataToRecover` FROM `TableToRecover` WHERE `ConditionToApply`;
	END
	$$
	DELIMITER ;
/* -------------------------------------------------------------------------------------------------------- */

										-- UPDATE STORED PROCEDURE --
/* --------------------------------------------------------------------------------------------------------------------------------- */
	DROP PROCEDURE IF EXISTS sp_Update;
	DELIMITER $$
	CREATE PROCEDURE sp_Update (TableToUpdate VARCHAR(50), VariableToUpdate VARCHAR(50), NewValue LONGTEXT, ConditionToApply LONGTEXT)
	BEGIN
		UPDATE `TableToUpdate` SET `VariableToUpdate` = `NewValue` WHERE `ConditionToApply`;
	END
	$$
	DELIMITER ;
/* --------------------------------------------------------------------------------------------------------------------------------- */

							-- DELETE STORED PROCEDURE --
/* ----------------------------------------------------------------------------- */
	DROP PROCEDURE IF EXISTS sp_Delete;
	DELIMITER $$
	CREATE PROCEDURE sp_Delete (TableToRecover VARCHAR(50), ConditionToApply LONGTEXT)
	BEGIN
		DELETE FROM `TableToRecover` WHERE `ConditionToApply`;
	END
	$$
	DELIMITER ;
/* ----------------------------------------------------------------------------- */