package com.aggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({ "com.aggregator" })
public class InsuranceAggregatorMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceAggregatorMasterApplication.class, args);
	}

}
