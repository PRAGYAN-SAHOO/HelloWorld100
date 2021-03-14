package com.atlas.runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
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
import com.atlas.service.AtlasCycle;

@Component
public class PricingCycleRunner implements ApplicationRunner {

	@Autowired
	Environment env;
	
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("PricingCycleRunner.run()");
		

		/*Double breakPrice = new	Breaks().getBreakPrice(args.getOptionValues("breakType").get(0));
		Double chainPrice = new Chain().getChainPrice(); 
		Double framePrice = new	Frame().getFramePrice(args.getOptionValues("frameType").get(0));
		Wheels wheels=new Wheels(); Double rimPrice = wheels.getRim().getRimPrice();
		Double spokesPrice = wheels.getSpokes().getSpokesPrice();
		Double tubePrice =wheels.getTube().getTubePrice(); 
		//		Double tyrePrice =wheels.getTyre().getTyrePrice(env.getProperty("TyreType")); 
		Double tyrePrice=wheels.getTyre().getTyrePrice1(args.getOptionValues("TyreType").get(0),
						args.getOptionValues("dateOfPricing").get(0));
		Double	wheelPrice=rimPrice+spokesPrice+tubePrice+tyrePrice;
		Double handlePrice = new HandleBar().getHandlePrice(args.getOptionValues("handleType").get(0));
		Double cyclePrice=breakPrice+chainPrice+framePrice+wheelPrice+handlePrice;
		System.out.println("cyclePrice :: "+cyclePrice);*/
		System.out.println("Thousand Cycle Price  = "+prepareNewCycle()*1000);
		//System.out.println(getCyclePrice());

	}

	public Double getCyclePrice() {
		Double breakPrice = new Breaks().getBreakPrice(env.getProperty("breakType"));
		Double chainPrice = new Chain().getChainPrice();
		Double framePrice = new Frame().getFramePrice(env.getProperty("frameType"));
		Wheels wheels=new Wheels();
		wheels.setRim(new Rim());
		wheels.setSpokes(new Spokes());
		wheels.setTube(new Tube());
		wheels.setTyre(new Tyre());
		Double rimPrice = wheels.getRim().getRimPrice();
		Double spokesPrice = wheels.getSpokes().getSpokesPrice();
		Double tubePrice = wheels.getTube().getTubePrice();
		Double seatPrice = new Seat().getSeatPrice(env.getProperty("seatType"));

		//		Double tyrePrice = wheels.getTyre().getTyrePrice(env.getProperty("TyreType"));
		Double tyrePrice = wheels.getTyre().getTyrePrice1(env.getProperty("TyreType"),env.getProperty("dateOfPricing"));
		Double wheelPrice=rimPrice+spokesPrice+tubePrice+tyrePrice;
		Double handlePrice = new HandleBar().getHandlePrice(env.getProperty("handleType"));
		Double cyclePrice=breakPrice+chainPrice+framePrice+wheelPrice+handlePrice+seatPrice;
		System.out.println("breakPrice  :: "+breakPrice);
		System.out.println("chainPrice  :: "+chainPrice);
		System.out.println("wheelPrice  :: "+wheelPrice);
		System.out.println("seatPrice  :: "+seatPrice);
		System.out.println("handlePrice  :: "+handlePrice);
		return cyclePrice;
	}
	public Double prepareNewCycle() {
		String property = env.getProperty("JAVA_HOME");
		System.out.println(property);
		Breaks breaks = new Breaks();
		Double breakPrice = breaks.getBreakPrice(env.getProperty("breakType"));
		Chain chain = new Chain();
		Double chainPrice = chain.getChainPrice();
		Frame frame = new Frame();
		Double framePrice = frame.getFramePrice(env.getProperty("frameType"));
		Wheels wheels = new Wheels();
		wheels.setRim(new Rim());
		wheels.setSpokes(new Spokes());
		wheels.setTube(new Tube());
		wheels.setTyre(new Tyre());
		Double rimPrice = wheels.getRim().getRimPrice();
		Double spokesPrice = wheels.getSpokes().getSpokesPrice();
		Double tubePrice = wheels.getTube().getTubePrice();
		Seat seat = new Seat();
		Double seatPrice = seat.getSeatPrice(env.getProperty("seatType"));
		
		//		Double tyrePrice = wheels.getTyre().getTyrePrice(env.getProperty("TyreType"));
		Double tyrePrice = wheels.getTyre().getTyrePrice1(env.getProperty("TyreType"),env.getProperty("dateOfPricing"));
	 	Double wheelPrice=rimPrice+spokesPrice+tubePrice+tyrePrice;
		HandleBar handleBar = new HandleBar();
		Double handlePrice = handleBar.getHandlePrice(env.getProperty("handleType"));
		Double cyclePrice=breakPrice+chainPrice+framePrice+wheelPrice+handlePrice+seatPrice;
		System.out.println("breakPrice  :: "+breakPrice);
		System.out.println("chainPrice  :: "+chainPrice);
		System.out.println("wheelPrice  :: "+wheelPrice);
		System.out.println("seatPrice  :: "+seatPrice);
		System.out.println("handlePrice  :: "+handlePrice);
		System.out.println("cyclePrice  :: "+cyclePrice);
		return  cyclePrice;

		/*new  AtlasCycle() {
			{
				setBreaks(breaks);
				setChain(chain);
				setFrame(frame);
				setWheels(wheels);
				setSeat(seat);
			}
		};
		return null;*/
	}

}
