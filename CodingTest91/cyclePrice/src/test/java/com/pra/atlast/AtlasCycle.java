package com.pra.atlast;

import org.springframework.stereotype.Component;

import com.atlas.model.Breaks;
import com.atlas.model.Chain;
import com.atlas.model.Frame;
import com.atlas.model.HandleBar;
import com.atlas.model.Rim;
import com.atlas.model.Seat;
import com.atlas.model.Spokes;
import com.atlas.model.Tube;
import com.atlas.model.Tyre;
import com.atlas.model.Wheels;

@Component
public class AtlasCycle implements Runnable {
	
	private Frame frame;
	private Seat seat;
	private Wheels wheels;
	private Breaks breaks;
	private HandleBar handleBar;
	private Chain chain;
	
	public Frame getFrame() {
		return frame;
	}
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public Wheels getWheels() {
		return wheels;
	}
	public void setWheels(Wheels wheels) {
		this.wheels = wheels;
	}
	public Breaks getBreaks() {
		return breaks;
	}
	public void setBreaks(Breaks breaks) {
		this.breaks = breaks;
	}
	public HandleBar getHandleBar() {
		return handleBar;
	}
	public void setHandleBar(HandleBar handleBar) {
		this.handleBar = handleBar;
	}
	public Chain getChain() {
		return chain;
	}
	public void setChain(Chain chain) {
		this.chain = chain;
	}
	
	public Double getCyclePrice(AtlasCycle cycle) {
		Double breakPrice = cycle.getBreaks().getBreakPrice(cycle.getBreaks().getBreakType());
		Double chainPrice = cycle.getChain().getChainPrice();
		Double framePrice = cycle.getFrame().getFramePrice(cycle.getFrame().getFrameMaterialTypes());
		Double seatPrice = cycle.getSeat().getSeatPrice(cycle.getSeat().getSeatType());
		Double rimPrice = cycle.getWheels().getRim().getRimPrice();
		Double spokesPrice = cycle.getWheels().getSpokes().getSpokesPrice();
		Double tubePrice = cycle.getWheels().getTube().getTubePrice();
		Double tyrePrice = cycle.getWheels().getTyre().getTyrePrice1(cycle.getWheels().getTyre().getTyreType(),cycle.getWheels().getTyre().getPricingDate());
		Double wheelPrice=rimPrice+spokesPrice+tubePrice+tyrePrice;
		Double handlePrice =cycle.getHandleBar().getHandlePrice(cycle.getHandleBar().getHandleType());
		Double cyclePrice=breakPrice+chainPrice+framePrice+wheelPrice+handlePrice+seatPrice;
		System.out.println("breakPrice  :: "+breakPrice);
		System.out.println("chainPrice  :: "+chainPrice);
		System.out.println("wheelPrice  :: "+wheelPrice);
		System.out.println("seatPrice  :: "+seatPrice);
		System.out.println("handlePrice  :: "+handlePrice);
		System.out.println("cyclePrice  :: "+cyclePrice);
		return cyclePrice;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
