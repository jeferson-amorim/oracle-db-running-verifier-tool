package com.oracledb.verifier.tool.arguments;

import java.util.regex.Pattern;

public class ArgumentsValidator {
	
	public boolean areArgumentsValid(String [] args) {
		for( String parameter : args ) {
			if ( ! isArgumentValid(parameter) ) {
				printUsage(parameter);
				return false;
			}
		}
		return true;
	}
	
	public boolean isArgumentValid(String parameter){
		return Pattern.matches("(user|password|database|server|port|attempts|spleepTime)=[a-zA-Z_0-9-]+", parameter);
	}
	
	private void printUsage(String invalidParameter){
		System.out.println( "Invalid param: " + invalidParameter );
		System.out.println("Valid parameters:");
		System.out.println(" user=<username>");
		System.out.println(" password=<password>");
		System.out.println(" database=<database>");
		System.out.println(" server=<server>");
		System.out.println(" port=<port>");
		System.out.println(" attempts=<attempts>");
		System.out.println(" sleepTime=<seconds>");
	}
}
