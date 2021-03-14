package com.atlas.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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

//@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AtlasCycleTest {
	@Autowired
	Environment env;

//	@Test
	public void test() {
		System.out.println("AtlasCycleTest.test()");
		AtlasCycle cycle = new AtlasCycle() {
			{
				this.setBreaks(new Breaks() {
					{
						this.setBreakType(env.getProperty("breakType"));
					}
				});
				
				this.setChain(new Chain());
				
				this.setHandleBar(new HandleBar() {
					{
						this.setHandleType(env.getProperty("handleType"));
					}
				});
				
				this.setWheels(new Wheels(){
					{
						this.setRim(new Rim());
						this.setSpokes(new Spokes());
						this.setTube(new Tube());
						this.setTyre(new Tyre() {
							{
								this.setTyreType(env.getProperty("TyreType"));
								this.setPricingDate(env.getProperty("dateOfPricing"));
							}
						});
					}
				});
				
				this.setFrame(new Frame() {
					{
						this.setFrameMaterialTypes(env.getProperty("frameType"));
					}
				});
				
				this.setSeat(new Seat() {
					{
						this.setSeatType(env.getProperty("seatType"));
					}
				});
			}
		};

		Double cyclePrice = new AtlasCycle().getCyclePrice(cycle);
		System.out.println("total cycle price :: " + cyclePrice);
	}

}
