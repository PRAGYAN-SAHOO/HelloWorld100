package com.atlas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.atlas.model.Breaks;
import com.atlas.model.Chain;
import com.atlas.model.Frame;
import com.atlas.model.HandleBar;
import com.atlas.model.Wheels;

@Component
public class AtlasCycleFactory {
	//private AtlasCycle cycle;
	
	@Autowired
	Environment env;
	
	public AtlasCycle prepareNewCycle(AtlasCycle atlasCycle) {
		System.out.println(env);
		
		if (env!=null) {
			
		Double breakPrice = new Breaks().getBreakPrice(env.getProperty("breakType"));
		Double chainPrice = new Chain().getChainPrice();
		Double framePrice = new Frame().getFramePrice(env.getProperty("frameType"));
		Wheels wheels=new Wheels();
		Double rimPrice = wheels.getRim().getRimPrice();
		Double spokesPrice = wheels.getSpokes().getSpokesPrice();
		Double tubePrice = wheels.getTube().getTubePrice();
//		Double tyrePrice = wheels.getTyre().getTyrePrice(env.getProperty("TyreType"));
		Double tyrePrice = wheels.getTyre().getTyrePrice1(env.getProperty("TyreType"),env.getProperty("dateOfPricing"));
		Double wheelPrice=rimPrice+spokesPrice+tubePrice+tyrePrice;
		Double handlePrice = new HandleBar().getHandlePrice(env.getProperty("handleType"));
		Double cyclePrice=breakPrice+chainPrice+framePrice+wheelPrice+handlePrice;
		System.out.println("cyclePrice :: "+cyclePrice);
		} 
		return null;
	}

}
