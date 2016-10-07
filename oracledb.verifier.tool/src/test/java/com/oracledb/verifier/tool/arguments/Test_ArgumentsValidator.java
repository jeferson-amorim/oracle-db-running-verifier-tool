package com.oracledb.verifier.tool.arguments;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.oracledb.verifier.tool.arguments.ArgumentsValidator;

public class Test_ArgumentsValidator {
	ArgumentsValidator validator;
	
	@Before
	public void setup(){
		validator = new ArgumentsValidator();
	}
	
	@Test
	public void test_isArgumentValid_with_correct_value(){
		
		boolean result = validator.isArgumentValid("server=db");
		
	    assertEquals( true, result);
	}
	
	@Test
	public void test_isArgumentValid_with_wrong_value(){
		
		boolean result = validator.isArgumentValid("server=^$#%#@!@!@%");
		
	    assertEquals( false, result);
	}
	
	@Test
	public void test_isArgumentValid_accepts_as_valid_server_name_with_dash(){
		
		boolean result = validator.isArgumentValid("server=savvion-db");
		
	    assertEquals( true, result);
	}
}
