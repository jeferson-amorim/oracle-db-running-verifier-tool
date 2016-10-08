package com.oracledb.verifier.tool;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import com.oracledb.verifier.tool.DTOs.DatabaseServerDTO;
import com.oracledb.verifier.tool.DTOs.CheckerDTO;

public class Check {
	DatabaseServerDTO _databaseServerDTO;
	CheckerDTO _checkerDTO;
	
	private int attemptsCount = 0;
	
	public Check(final DatabaseServerDTO databaseServerDTO, final CheckerDTO checkerDTO) {
		if (databaseServerDTO == null) {
			throw new IllegalArgumentException();
		}
		if (checkerDTO == null) {
			throw new IllegalArgumentException();
		}
		_databaseServerDTO = databaseServerDTO;
		_checkerDTO = checkerDTO;
	}
	
	public void verifyDatabaseIsRunning() {
		printConnectionTest();

		boolean isUp = isUp();

		if (isUp) {
			System.out.println("-------- Oracle is up and running ------");
		} else {
			System.out.println("-------- Can't connect to oracle after " + 
							   _checkerDTO.maxAttempts +
							   " attempts ------");
			System.exit(1);
		}
	}
	
	public void printConnectionTest() {
		System.out.println("-------- Oracle Connection Testing ------");
		System.out.println("Server: " + _databaseServerDTO.server);
		System.out.println("Port: " + _databaseServerDTO.port);
		System.out.println("DB: " + _databaseServerDTO.database);
		System.out.println("user: " + _databaseServerDTO.user);
		System.out.println("password: " + _databaseServerDTO.password);
	}

	private boolean isUp() {
		try {
			Statement stmt = getConn().createStatement();
			stmt.executeQuery("select * from dual");
			return true;
		} catch (SQLException e) {
			attemptsCount++;
			System.out.println("Database not ready yet.");
			sleep();
		}

		if (attemptsCount < _checkerDTO.maxAttempts)
			return isUp();

		return false;
	}

	private Connection getConn() throws SQLException {
		String connUrl = String.format("jdbc:oracle:thin:@%s:%s:%s",
										_databaseServerDTO.server,
										_databaseServerDTO.port,
										_databaseServerDTO.database);
		return DriverManager.getConnection(connUrl,
										   _databaseServerDTO.user,
										   _databaseServerDTO.password);
	}
	
	private void sleep() {
		try {
			Thread.sleep(_checkerDTO.sleepTime * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	
}
