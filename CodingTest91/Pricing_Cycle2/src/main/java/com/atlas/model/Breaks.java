package com.atlas.model;

import java.util.HashMap;
import java.util.Map;

public class Breaks {
	
	private String breakType;
	
	public String getBreakType() {
		return breakType;
	}

	public void setBreakType(String breakType) {
		this.breakType = breakType;
	}

	private static Map<String,Double> breakPrices=new HashMap<>();
	
	static {
		breakPrices.put("disc", 500D);
		breakPrices.put("normal", 300D);
	}
	
	public Double getBreakPrice(String breakType) {
		return breakPrices.get(breakType);
	}

}
