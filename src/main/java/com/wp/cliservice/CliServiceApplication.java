package com.wp.cliservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class CliServiceApplication{
	private static final Logger logger = LoggerFactory.getLogger(CliServiceApplication.class);
	@Autowired
	private DiscoveryClient discoverClient;
	
	@RequestMapping(value="getHello",method=RequestMethod.GET)
	public String getHello() {
		logger.info("DiscoveryClient"+discoverClient.toString());
		List<String>  services =discoverClient.getServices();
		for (String service : services) {
			logger.info("--------------serviceUrl----------:"+service);
		}
		System.out.println('a');
		return "CliService";
	}
	public static void main(String[] args) {
		SpringApplication.run(CliServiceApplication.class, args);
	}
	
}
