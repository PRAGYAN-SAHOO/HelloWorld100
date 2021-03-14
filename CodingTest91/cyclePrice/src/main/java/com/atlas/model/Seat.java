package com.atlas.model;

import java.util.HashMap;
import java.util.Map;

public class Seat {
	private String seatType;
	
	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}


	public Double getSeatPrice(String seatType) {
		Map<String,Double>  map= new HashMap<>();
			map.put("Suspension", 500D);
			map.put("NoSuspension", 200D);
		return map.get(seatType);
	}
	
}
