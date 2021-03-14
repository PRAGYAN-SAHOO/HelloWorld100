package com.atlas.model;

import java.util.HashMap;
import java.util.Map;

public class FrameMaterialTypes {
	
	private static Map<String,Double>  map= new HashMap<>();
	static {
		map.put("Steel", 1000D);
		map.put("Aluminum", 1500D);
		map.put("Titanium", 2000D);
	}

	public static void main(String[] args) {
		map.forEach((a,b)->
		System.out.println(a + " " + b)
		);
	}
}
