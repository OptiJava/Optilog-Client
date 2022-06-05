package com.optilog;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;

public class JavaTest {
	public static void main(String[] args) throws FileNotFoundException {
		Yaml yaml = new Yaml();
		Map<String, LinkedHashMap> map = yaml.load(new FileInputStream("D:\\Program\\Project\\resources\\app\\Git\\Projects\\Optilog-Client\\src\\test\\resources\\Settings.yaml"));
		System.out.println(map.get("info").get("print"));
	}
}
