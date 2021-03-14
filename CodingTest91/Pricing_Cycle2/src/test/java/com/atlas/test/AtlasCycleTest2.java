package com.atlas.test;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

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

@SpringBootTest
public class AtlasCycleTest2 {
	
	@Autowired
	Environment env;
	Double totalCyclePrice=0D;
	
	@Test
	public void test() {
		System.out.println("AtlasCycleTest2.test()");
		Integer threadCounter = 0;
		/*
		BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(50);
		
		CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor(10,
				10, 5000, TimeUnit.MILLISECONDS, blockingQueue);
		
		executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
			@Override
			public void rejectedExecution(Runnable r,
					ThreadPoolExecutor executor) {
				 System.out.println("Task Rejected : ");
		       System.out.println("Waiting for a second !!");
				 try {
					 Thread.sleep(1000);
				 } catch (InterruptedException e) {
					 e.printStackTrace();
				 }
				 System.out.println("Lets add another time : "
				   + r.getClass());
				 executor.execute(r);
			}
		});
		// Let start all core threads initially
		executor.prestartAllCoreThreads();*/
		while (true) {
			threadCounter++;
			// Adding threads one by one
			System.out.println("Adding Task : " + threadCounter);
			getCyclePrice();
			if (threadCounter == 1000)
				break;
		}
		System.out.println("\ntotal cycle count :: " + threadCounter);
		System.out.println("total cycle Price :: " + totalCyclePrice);
	}
	
	public void getCyclePrice() {

		System.out.println("AtlasCycleTest2.getCyclePrice()");
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
		System.out.println("cycle price :: " + cyclePrice);
		totalCyclePrice+=cyclePrice;
	}

}
