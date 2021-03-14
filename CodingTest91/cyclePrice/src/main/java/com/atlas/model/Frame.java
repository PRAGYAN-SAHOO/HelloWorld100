package com.atlas.model;

import java.util.HashMap;
import java.util.Map;

public class Frame {
	private double topTube;
	private double downTube;
	private double seatTube;
	private double seatStay;
	private String FrameMaterialTypes;

	public double getTopTube() {
		return 100D;
	}

	public void setTopTube(double topTube) {
		this.topTube = topTube;
	}

	public double getDownTube() {
		return 100D;
	}

	public void setDownTube(double downTube) {
		this.downTube = downTube;
	}

	public double getSeatTube() {
		return 100D;
	}

	public void setSeatTube(double seatTube) {
		this.seatTube = seatTube;
	}

	public double getSeatStay() {
		return 100D;
	}

	public void setSeatStay(double seatStay) {
		this.seatStay = seatStay;
	}

	public Double getFramePrice(String frameMaterialType) {
		Map<String, Double> map = new HashMap<>();
		map.put("SteelFrame", 1000D);
		map.put("AluminumFrame", 1500D);
		map.put("TitaniumFrame", 2000D);
		return map.get(frameMaterialType)+getDownTube()+getSeatStay()+getTopTube()+getSeatTube();
	}

	public String getFrameMaterialTypes() {
		return FrameMaterialTypes;
	}

	public void setFrameMaterialTypes(String frameMaterialTypes) {
		FrameMaterialTypes = frameMaterialTypes;
	}

	@Override
	public String toString() {
		return "Frame [topTube=" + topTube + ", downTube=" + downTube + ", seatTube=" + seatTube + ", seatStay="
				+ seatStay + ", FrameMaterialTypes=" + FrameMaterialTypes + "]";
	}

}
