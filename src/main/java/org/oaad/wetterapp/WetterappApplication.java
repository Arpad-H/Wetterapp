package org.oaad.wetterapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class of the application
 * @Author Alexander Iwan
 */

@SpringBootApplication
public class WetterappApplication {

	/**
	 * Main method of the application. Launches Servlet container and starts the application.
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(WetterappApplication.class, args);
	}
}
