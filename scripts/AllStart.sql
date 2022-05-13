/**
 * PROJECT NAME: 
 * 		MySQL Maker
 * PROJECT DESCRIPTION:
 * 		GUI for the creation of MySQL code in an automated way
 * FILE NAME:
 * 		AllStart.sql
 * FILE DESCRIPTION:
 * 		Application's BD creator script
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
	CREATE PROCEDURE sp_Insert (IN TableToInsert VARCHAR(50), IN FieldsToFill LONGTEXT, IN ValuesToInsert LONGTEXT)
	BEGIN
		DECLARE InsertQuery LONGTEXT;
        
        SET @InsertQuery = CONCAT('INSERT INTO ', TableToInsert, ' (' , FieldsToFill , ') VALUES (' , ValuesToInsert , ');');
        
        PREPARE InsertQueryStatement FROM @InsertQuery;
        
        EXECUTE InsertQueryStatement;
        
        DEALLOCATE PREPARE InsertQueryStatement;
	END
	$$
	DELIMITER ;
/* ------------------------------------------------------------------------------------------------------ */    

										-- SELECT STORED PROCEDURE --
/* -------------------------------------------------------------------------------------------------------- */
	DROP PROCEDURE IF EXISTS sp_Select;
	DELIMITER $$
	CREATE PROCEDURE sp_Select (DataToRecover VARCHAR(50), TableToRecover VARCHAR(50))
	BEGIN
        DECLARE SelectQuery LONGTEXT;
        
        SET @SelectQuery = CONCAT('SELECT ', DataToRecover, ' FROM ', TableToRecover);
        
        PREPARE SelectQueryStatement FROM @SelectQuery;
        
        EXECUTE SelectQueryStatement;
        
        DEALLOCATE PREPARE SelectQueryStatement;
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
        DECLARE UpdateQuery LONGTEXT;
        
        SET @UpdateQuery = CONCAT('UPDATE ', TableToUpdate, ' SET ', VariableToUpdate, ' = ', NewValue, ' WHERE ', ConditionToApply);
        
        PREPARE UpdateQueryStatement FROM @UpdateQuery;
        
        EXECUTE UpdateQueryStatement;
        
        DEALLOCATE PREPARE UpdateQueryStatement;
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
        DECLARE DeleteQuery LONGTEXT;
        
        SET @DeleteQuery = CONCAT('DELETE FROM ', TableToRecover, ' WHERE ', ConditionToApply);
        
        PREPARE DeleteQueryStatement FROM @DeleteQuery;
        
        EXECUTE DeleteQueryStatement;
        
        DEALLOCATE PREPARE DeleteQueryStatement;
	END
	$$
	DELIMITER ;
/* ----------------------------------------------------------------------------- */