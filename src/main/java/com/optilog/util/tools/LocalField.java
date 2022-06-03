package com.optilog.util.tools;

import java.util.HashMap;
import java.util.Map;

public class LocalField {
	private static final Map<Object, Object> map = new HashMap<>();
	
	public static void addField(Object fieldName, Object value) {
		LocalField.map.put(fieldName, value);
	}
	
	public static Object getField(Object fieldName) {
		return LocalField.map.get(fieldName);
	}
	
	public static void removeField(Object key) {
		LocalField.map.remove(key);
	}
}
