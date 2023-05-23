package com.example.orderbook;

import com.example.orderbook.config.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
public class OrderbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderbookApplication.class, args);
	}

}
