package com.oracledb.verifier.tool.arguments;

import java.util.Map;

import com.oracledb.verifier.tool.DTOs.CheckerDTO;
import com.oracledb.verifier.tool.DTOs.DatabaseServerDTO;

public class ArgumentsMapper {

	public DatabaseServerDTO mapDatabaseServerFrom(Map<String, String> map) {
		DatabaseServerDTO dto = new DatabaseServerDTO();
		
		dto.server   = map.getOrDefault("server", "db");
		dto.database = map.getOrDefault("database", "XE");
		dto.user     = map.getOrDefault("user", "ebms");
		dto.password = map.getOrDefault("password", "ebms");
		dto.port     = map.getOrDefault("port", "1521");
		
		return dto;
	}
	
	public CheckerDTO mapCheckerFrom(Map<String, String> map) {
		CheckerDTO dto = new CheckerDTO();
		
		dto.maxAttempts = Integer.parseInt(map.getOrDefault("maxAttempts", "35"));
		dto.sleepTime   = Integer.parseInt(map.getOrDefault("sleepTime", "5"));
		
		return dto;
	}
}
