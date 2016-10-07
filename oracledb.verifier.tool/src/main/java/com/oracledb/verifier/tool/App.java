package com.oracledb.verifier.tool;

import java.util.Map;
import com.oracledb.verifier.tool.arguments.ArgumentsValidator;
import com.oracledb.verifier.tool.arguments.ArgumentsMapper;
import com.oracledb.verifier.tool.arguments.ArgumentsParser;
import com.oracledb.verifier.tool.DTOs.CheckerDTO;
import com.oracledb.verifier.tool.DTOs.DatabaseServerDTO;

public class App {
	
	public static void main(String[] argv) {
		
		final ArgumentsValidator argumentsValidator = new ArgumentsValidator();
		if( ! argumentsValidator.areArgumentsValid(argv)){
			System.exit(1);
		}
		
		final ArgumentsParser parser = new ArgumentsParser();
		Map<String, String> map = parser.createMapFrom(argv);
		
		final ArgumentsMapper mapper = new ArgumentsMapper();
		DatabaseServerDTO databaseServerDTO = mapper.mapDatabaseServerFrom(map);
		CheckerDTO checkerDTO = mapper.mapCheckerFrom(map);
		
		final Check checker = new Check( databaseServerDTO, checkerDTO);
		
		checker.verifyDatabaseIsRunning();
	}
}
