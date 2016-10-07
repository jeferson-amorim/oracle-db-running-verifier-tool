package com.oracledb.verifier.tool.arguments;

import java.util.HashMap;
import java.util.Map;

public class ArgumentsParser {

	public Map<String, String> createMapFrom(final String[] arguments) {
        final Map<String, String> map = new HashMap<String, String>();
        for	(String pair : arguments) {
        	String[] kv = pair.split("=");
        	map.put(kv[0], kv[1]);
        }
        return map;
    }
}
