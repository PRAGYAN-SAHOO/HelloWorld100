package com.atlas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CyclePricingApplication {

	public static void main(String[] args) {
		System.out.println("DemoApplication.main()-----start");
		SpringApplication.run(CyclePricingApplication.class, args);
		System.out.println("DemoApplication.main()-----stop");
	}

}
