package com.oracledb.verifier.tool.arguments;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.oracledb.verifier.tool.arguments.ArgumentsParser;

public class Test_ArgumentParser {
	
	ArgumentsParser _parser;
	
	@Before
	public void setup(){
		_parser = new ArgumentsParser();
	}
	
	@Test
	public void test_parse_correctly_one_argument(){
		String[] args = { "name=testname" };
		
		Map<String, String> result = _parser.createMapFrom(args);
		
		String expected = "testname";		
	    assertEquals( expected, result.get("name"));
	}
	
	@Test
	public void test_parse_correctly_two_arguments(){
		String[] args = { "name=testname2", "server=theserver" };
		
		Map<String, String> result = _parser.createMapFrom(args);
		
		String expected = "testname2";		
	    assertEquals( expected, result.get("name"));
	    
	    expected = "theserver";		
	    assertEquals( expected, result.get("server"));
	}	
	
}
