package com.oracledb.verifier.tool.arguments;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.oracledb.verifier.tool.DTOs.CheckerDTO;
import com.oracledb.verifier.tool.DTOs.DatabaseServerDTO;

public class Test_ArgumentsMapper {
	
	ArgumentsMapper _sut;
	
	@Before
	public void setup(){
		_sut = new ArgumentsMapper();
	}
	
	@Test
	public void test_maps_CheckerDTO_with_one_argument(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("sleepTime",  "120");
		
		CheckerDTO result = _sut.mapCheckerFrom(map);
		
		int expected = 120;
	    assertEquals( expected, result.sleepTime);
	}
	
	@Test
	public void test_maps_CheckerDTO_with_one_argument_and_another_with_default_value(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("maxAttempts",  "31");
		
		CheckerDTO result = _sut.mapCheckerFrom(map);
		
		int expected = 31;
	    assertEquals( expected, result.maxAttempts);
	    
	    int defaultValueOf_sleepTime = 5;
	    assertEquals( defaultValueOf_sleepTime, result.sleepTime );
	}
	
	@Test
	public void test_maps_DatabaseServerDTO_all_arguments_mapped(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("server", "s1");
		map.put("database", "db1");
		map.put("port", "port1");
		map.put("user", "user1");
		map.put("password", "password1");
		
		DatabaseServerDTO result = _sut.mapDatabaseServerFrom(map);
		
		assertEquals( "s1", result.server);
		assertEquals( "db1", result.database);
		assertEquals( "port1", result.port);
		assertEquals( "user1", result.user);
		assertEquals( "password1", result.password);
	}
	
}
