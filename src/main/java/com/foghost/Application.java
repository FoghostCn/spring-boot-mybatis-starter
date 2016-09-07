package com.foghost;

import com.foghost.utils.PortForwardingL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		PortForwardingL.run();
		SpringApplication.run(Application.class, args);
	}

}