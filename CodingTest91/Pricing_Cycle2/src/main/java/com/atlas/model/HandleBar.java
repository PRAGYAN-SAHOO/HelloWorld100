package com.atlas.model;

import java.util.HashMap;
import java.util.Map;

public class HandleBar {
	private String handleType;
	
	public String getHandleType() {
		return handleType;
	}

	public void setHandleType(String handleType) {
		this.handleType = handleType;
	}


	public Double getHandlePrice(String handleType) {
	 Map<String,Double>  map= new HashMap<>();
			map.put("flat", 1000D);
			map.put("curve", 2000D);
		return map.get(handleType);
	}

}
